package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_LIKE_COUNT)
@NamedQueries({
		@NamedQuery(
				name = "getEmpId",
				query = "SELECT l FROM Like AS l WHERE l.reportId = :" + "report_id" + " ORDER BY l.id DESC")
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {

	/**
	 * id
	 */
	@Id
	@Column(name = JpaConst.LIKE_COL_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 従業員のid
	 */
	@Column(name = JpaConst.LIKE_COL_EMP, nullable = false)
	private Integer employeeId;

	/**
	 * 日報のid
	 */
	@Column(name = JpaConst.LIKE_COL_REP, nullable = false)
	private Integer reportId;

	/**
	 * 登録日時
	 */
	@Column(name = JpaConst.LIKE_COL_CREATED_AT, nullable = false)
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	@Column(name = JpaConst.LIKE_COL_UPDATED_AT, nullable = false)
	private LocalDateTime updatedAt;
}
