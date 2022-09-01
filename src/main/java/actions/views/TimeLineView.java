package actions.views;

import java.time.LocalDateTime;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_TIME_LINE)
@NamedQueries({
	@NamedQuery(
			name = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP,
			query = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP_DEF),
	@NamedQuery(
			name = JpaConst.Q_TIME_LINE_GET_FOLLOW_REP,
			query = JpaConst.Q_TIME_LINE_COUNT_FOLLOW_REP_DEF)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeLineView {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * ログイン中の従業員
	 */
	private EmployeeView loginEmployee;

	/**
	 * フォローした従業員の日報
	 */
	private EmployeeView followEmployee;

	/**
	 * 登録日時
	 */
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	private LocalDateTime updatedAt;
}
