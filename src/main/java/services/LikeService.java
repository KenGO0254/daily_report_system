package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.LikeConverter;
import actions.views.LikeView;
import constants.JpaConst;
import models.Like;

public class LikeService extends ServiceBase {

	/**
	 * 指定した日報のidを利用していいねした人の情報を取得する
	 * @param reportId
	 * @param page
	 * @return
	 */
	public List<LikeView> getLikePerPage(int reportId, int page){
		List<Like> likes = em.createNamedQuery(JpaConst.Q_LIKE_GET_EMP_ID, Like.class)
				.setParameter(JpaConst.JPQL_PARM_REPORT_ID, reportId)
				.setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
				.setMaxResults(JpaConst.ROW_PER_PAGE)
				.getResultList();

		return LikeConverter.toViewList(likes);
	}

	/**
	 * いいねした人の人数を取得する
	 * @param likes 取得したいいね情報
	 * @return いいねした人の人数
	 */
	public long countByReportId(int reportId) {
		long count = (long)em.createNamedQuery(JpaConst.Q_LIKE_COUNT_ALL_LIKE, Long.class)
				.setParameter(JpaConst.JPQL_PARM_REPORT_ID, reportId)
				.getSingleResult();

		return count;
	}

	/**
	 * ログイン中の従業員情報といいねした日報のidを持つレコードがいいねした人一覧に何件あるか取得する
	 * @param reportId, employee
	 * @return レコードの件数
	 */
	public long countMatchId(int reportId, EmployeeView employee) {
		long count = (long)em.createNamedQuery(JpaConst.Q_LIKE_COUNT_MATCH_ID, Long.class)
				.setParameter(JpaConst.JPQL_PARM_REPORT_ID, reportId)
				.setParameter(JpaConst.JPQL_PARM_EMPLOYEE,  EmployeeConverter.toModel(employee))
				.getSingleResult();

		return count;
	}

	/**
	 * idを条件にデータを1件取得する
	 * @param id
	 * @return 取得データのインスタンス
	 */
	private Like findOneInternal(int id) {
		return em.find(Like.class, id);
	}

	/**
	 * 「いいねを解除する」リンクが押された時に従業員のidと日報のidを元にしていいね状態を解除する
	 * @param employee ログイン中の従業員
	 * @param report いいねした日報
	 */
	public void unLikeRep(EmployeeView employee, int reportId) {
		Like l = em.createNamedQuery(JpaConst.Q_LIKE_COUNT_GET_REP_EMP, Like.class)
				.setParameter(JpaConst.JPQL_PARM_REPORT_ID, reportId)
				.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
				.getSingleResult();

		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 「この日報にいいねする」リンクが押された時に従業員のidと日報のidを元にデータを1件作成し、いいねした人一覧に登録する
	 * @param lv いいねした人一覧への登録内容
	 */
	public void create(LikeView lv){

		//登録日時、更新日時に現在時刻を設定
		LocalDateTime now = LocalDateTime.now();
		lv.setCreatedAt(now);
		lv.setUpdatedAt(now);

		//データを登録
		createInternal(lv);
	 }

	/**
	 * 画面から入力された更新内容を元にデータを1件作成して、いいねした人一覧を更新する
	 * @param lv いいねした人一覧の更新内容
	 */
	public void update(LikeView lv) {
		LocalDateTime ldt = LocalDateTime.now();
		lv.setUpdatedAt(ldt);

		updateInternal(lv);
	}


	/**
	 * いいねした人一覧にデータを1件登録する
	 * @param lv いいねした人一覧のデータ
	 */
	private void createInternal(LikeView lv) {
		em.getTransaction().begin();
		em.persist(LikeConverter.toModel(lv));
		em.getTransaction().commit();
	}

	/**
	 * いいねした人一覧のデータを更新する
	 * @param lv いいねした人一覧のデータ
	 */
	private void updateInternal(LikeView lv) {
		em.getTransaction().begin();
		Like l = findOneInternal(lv.getId());
		LikeConverter.copyViewToModel(l, lv);
		em.getTransaction().commit();
	}
}
