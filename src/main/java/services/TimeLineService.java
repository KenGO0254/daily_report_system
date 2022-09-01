package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import actions.views.TimeLineConverter;
import actions.views.TimeLineView;
import constants.JpaConst;
import models.Report;

public class TimeLineService extends ServiceBase{
	/**
	 * ログイン中の従業員がフォローした従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得しReportViewのリストで返却する
	 * @param loginEmployee
	 * @param page ページ数
	 * @return 一覧画面に表示するデータのリスト
	 */
	public List<ReportView> getFollowPerPage(EmployeeView loginEmployee, int page){
		List<Report> reports = em.createNamedQuery(JpaConst.Q_TIME_LINE_GET_FOLLOW_REP, Report.class)
				.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(loginEmployee))
				.setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
				.setMaxResults(JpaConst.ROW_PER_PAGE)
				.getResultList();

		return ReportConverter.toViewList(reports);
	}

	/**
	 * ログイン中の従業員がフォローした従業員の日報の件数を取得し、返却する
	 * @param loginEmployee
	 * @return 日報データの件数
	 */
	public long countFollowRep(EmployeeView employee) {
		long count = (long)em.createNamedQuery(JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP, Long.class)
				.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
				.getSingleResult();

		return count;
	}

	/**
	 * 画面で「この日報の作成者をフォローする」リンクが押された時にタイムラインテーブルにデータを登録する
	 */
	public void create(EmployeeView loginEmployee, EmployeeView followEmployee) {
		TimeLineView tlv = new TimeLineView();
		LocalDateTime ldt = LocalDateTime.now();
		tlv.setLoginEmployee(loginEmployee);
		tlv.setFollowEmployee(followEmployee);
		tlv.setCreatedAt(ldt);
		tlv.setUpdatedAt(ldt);
		createInternal(tlv);
	}

	private void createInternal(TimeLineView tlv) {
		em.getTransaction().begin();
		em.persist(TimeLineConverter.toModel(tlv));
		em.getTransaction().commit();
	}
}
