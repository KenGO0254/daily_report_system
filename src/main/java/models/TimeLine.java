package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * 日報データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_TIME_LINE)
@NamedQueries({
	@NamedQuery(
			name = JpaConst.Q_TIME_LINE_GET_FOLLOW_REP,
			query = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP_DEF),
	@NamedQuery(
			name = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP,
			query = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP_DEF)
})
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class TimeLine {
	/**
	 * id
	 */
	@Id
	@Column(name = JpaConst.TIME_LINE_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * ログイン中の従業員
	 */
	@ManyToOne
	@JoinColumn(name = JpaConst.TIME_LINE_LOGIN_EMP, nullable = false)
	private Employee loginEmployee;

	/**
	 * フォローした従業員
	 */
	@ManyToOne
	@JoinColumn(name = JpaConst.TIME_LINE_FOLLOW_EMP, nullable = false)
	private Employee followEmployee;

	/**
	 * 登録日時
	 */
	@Column(name = JpaConst.TIME_LINE_CREATED_AT, nullable = false)
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	@Column(name = JpaConst.TIME_LINE_UPDATED_AT, nullable = false)
	private LocalDateTime updatedAt;

}
