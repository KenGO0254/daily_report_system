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

@Table(name = JpaConst.TABLE_LIKE_COUNT)
@NamedQueries({
		@NamedQuery(
				name = JpaConst.Q_LIKE_GET_EMP_ID,
				query = JpaConst.Q_LIKE_GET_EMP_ID_DEF),
		@NamedQuery(
				name = JpaConst.Q_LIKE_COUNT_ALL_LIKE,
				query = JpaConst.Q_LIKE_COUNT_ALL_LIKE_DEF),
		@NamedQuery(
				name = JpaConst.Q_LIKE_COUNT_MATCH_ID,
				query = JpaConst.Q_LIKE_COUNT_MATCH_ID_DEF)
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
	 * いいねした従業員
	 */
	@ManyToOne
	@JoinColumn(name = JpaConst.LIKE_COL_EMP, nullable = false)
	private Employee employee;

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
