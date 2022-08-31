package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	 * フォローした従業員
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
