package constants;

//DB関連の項目値を定義するインターフェース
//インターフェースに定義した変数はpublic static final 修飾子がついているとみなされる

public interface JpaConst {

	//persistence-unit名
	String PERSISTENCE_UNIT_NAME = "daily_report_system";

	//データ取得件数の最大値
	int ROW_PER_PAGE = 15; //1ページに表示するレコードの数

	//従業員テーブル
	String TABLE_EMP = "employees"; //テーブル名
	//従業員テーブルカラム
	String EMP_COL_ID = "id"; //id
	String EMP_COL_CODE = "code"; //社員番号
	String EMP_COL_NAME = "name"; //氏名
	String EMP_COL_PASS = "password"; //パスワード
	String EMP_COL_ADMIN_FLAG = "admin_flag"; //管理者権限
	String EMP_COL_CREATED_AT = "created_at"; //登録日時
	String EMP_COL_UPDATED_AT = "updated_at"; //更新日時
	String EMP_COL_DELETE_FLAG = "delete_flag"; //削除フラグ

	int ROLE_ADMIN = 1;//管理者権限ON(管理者)
	int ROLE_GENERAL = 0;//管理者権限OFF(一般)
	int EMP_DEL_TRUE = 1;//削除フラグON(削除済み)
	int EMP_DEL_FALSE = 0;//削除フラグOFF(現役)

	//日報テーブル
	String TABLE_REP = "reports"; //テーブル名

	//日報テーブルカラム
	String REP_COL_ID = "id"; //id
	String REP_COL_EMP = "employee_id";//日報を作成した従業員のid
	String REP_COL_REP_DATE = "report_date";//いつの日報かを示す日付
	String REP_COL_TITLE = "title";//日報のタイトル
	String REP_COL_CONTENT = "content";//日報の内容
	String REP_COL_CREATED_AT = "created_at";//登録日時
	String REP_COL_UPDATED_AT = "updated_at";//更新日時
	String REP_COL_LIKE_COUNT = "like_count";//いいね数

	//いいねした人一覧テーブル
	String TABLE_LIKE_COUNT = "likeCounts"; //テーブル名

	//いいねした人一覧テーブルカラム
	String LIKE_COL_ID = "id"; //id
	String LIKE_COL_EMP = "employee_id"; //従業員のid
	String LIKE_COL_REP = "report_id"; //日報のid
	String LIKE_COL_CREATED_AT = "created_at"; //登録日時
	String LIKE_COL_UPDATED_AT = "updated_at"; //更新日時

	//タイムラインテーブル
	String TABLE_TIME_LINE = "timeLine";

	//タイムラインテーブルカラム
	String TIME_LINE_ID = "id";
	String TIME_LINE_LOGIN_EMP = "login_employee_id";
	String TIME_LINE_FOLLOW_EMP = "follow_employee_id";
	String TIME_LINE_CREATED_AT = "created_at";
	String TIME_LINE_UPDATED_AT = "updated_at";

	//Entity名
	String ENTITY_EMP = "employee"; //従業員
	String ENTITY_REP = "report"; //日報
	String ENTITY_LIKE = "like"; //いいねした人一覧

	//JPQL内パラメータ
	String JPQL_PARM_CODE = "code"; //社員番号
	String JPQL_PARM_PASSWORD = "password"; //パスワード
	String JPQL_PARM_EMPLOYEE = "employee"; //従業員
	String JPQL_PARM_REPORT_ID = "report_id";//日報にいいねした従業員のid
	String JPQL_PARM_LOGIN_EMPLOYEE = "login_employee";//ログイン中の従業員
	String JPQL_PARM_FOLLOW_EMPLOYEE = "follow_employee";//フォローされた従業員

	//NameQueryのnameとquery
	//全ての従業員をidの降順に取得する
	String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll";
	String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e ORDER BY e.id DESC";

	//全ての従業員の件数を取得する
	String Q_EMP_COUNT = ENTITY_EMP + ".count";
	String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";

	//社員番号とハッシュ化済パスワードを条件に未削除の従業員を取得する
	String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
	String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :"
			+ JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;

	//指定した社員番号を保持する従業員の件数を取得する
	String Q_EMP_COUNT_REGISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
	String Q_EMP_COUNT_REGISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;

	//全ての日報をidの降順に取得する
	String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
	String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";

	//全ての日報の件数を取得する
	String Q_REP_COUNT = ENTITY_REP + ".count";
	String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";

	//指定した従業員が作成した日報を全件idの降順で取得する
	String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
	String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE
			+ " ORDER BY r.id DESC";

	//指定した従業員が作成した日報の件数を取得する
	String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
	String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;

	//指定した日報をいいねした従業員のidを全て降順で取得する
	String Q_LIKE_GET_EMP_ID = "getEmpId";
	String Q_LIKE_GET_EMP_ID_DEF = "SELECT l FROM Like AS l WHERE l.reportId = :" + JPQL_PARM_REPORT_ID + " ORDER BY l.id DESC";

	//指定した日報がいいねされた件数を取得
	String Q_LIKE_COUNT_ALL_LIKE = "countAllLike";
	String Q_LIKE_COUNT_ALL_LIKE_DEF = "SELECT COUNT(l) FROM Like AS l WHERE l.reportId = :" + JPQL_PARM_REPORT_ID;

	//ログイン中の従業員が指定した日報にいいねした回数を取得
	String Q_LIKE_COUNT_MATCH_ID = "countMatchId";
	String Q_LIKE_COUNT_MATCH_ID_DEF = "SELECT COUNT(l) FROM Like AS l WHERE l.reportId = :" + JPQL_PARM_REPORT_ID + " AND l.employee = :" + JPQL_PARM_EMPLOYEE;

	//ログイン中の従業員がフォローしている従業員の日報情報を降順で取得
	String Q_TIME_LINE_GET_FOLLOW_REP = "getFollowRep";
	String Q_TIME_LINE_GET_FOLLOW_REP_DEF = "SELECT r FROM Report AS r, TimeLine AS tl WHERE r.employee = tl.followEmployee AND tl.loginEmployee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";

	//ログイン中の従業員がフォローした従業員の日報の件数を取得
	String Q_TIME_LINE_COUNT_FOLLOW_REP = "countFollowRep";
	String Q_TIME_LINE_COUNT_FOLLOW_REP_DEF = "SELECT COUNT(r) FROM Report AS r, TimeLine AS tl WHERE r.employee = tl.followEmployee AND tl.loginEmployee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";

	//表示している日報を作成した従業員のidとログイン中の従業員のidを持つレコードの件数を取得
	String Q_TIME_LINE_COUNT_FOLLOW_EMP = "countFollowEmp";
	String Q_TIME_LINE_COUNT_FOLLOW_EMP_DEF = "SELECT COUNT(tl) FROM TimeLine AS tl WHERE tl.loginEmployee = :" + JPQL_PARM_LOGIN_EMPLOYEE + " AND tl.followEmployee = :" + JPQL_PARM_FOLLOW_EMPLOYEE;

	//従業員のフォロー状態を解除する
	String Q_TIME_LINE_UNFOLLOW = "unFollow";
	String Q_TIME_LINE_UNFOLLOW_DEF = "SELECT tl FROM TimeLine AS tl WHERE tl.loginEmployee = :" + JPQL_PARM_LOGIN_EMPLOYEE + " AND tl.followEmployee = :" + JPQL_PARM_FOLLOW_EMPLOYEE;
}
