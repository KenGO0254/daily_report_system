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
public class LikeView {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * いいねした従業員
	 */
	private EmployeeView employee;

	/**
	 * 日報のid
	 */
	private Integer reportId;

	/**
	 * 登録日時
	 */
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	private LocalDateTime updatedAt;
}
