package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "likeCounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Like {

	/**
	 * id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 従業員のid
	 */
	@Column(name = "employee_id", nullable = false)
	private Integer employee_id;

	/**
	 * 日報のid
	 */
	@Column(name = "report_id", nullable = false)
	private Integer report_id;

	/**
	 * 登録日時
	 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
