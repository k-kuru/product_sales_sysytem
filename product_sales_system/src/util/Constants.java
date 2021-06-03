package util;
/**
 * 定数クラス
 */
public class Constants {

	/** インスタンス化を禁止 */
	private Constants() {
	}

	/** 一般社員の権限を表す */
	public static final int USER = 1;

	/** 管理者の権限を表す */
	public static final int SYSTEM = 2;

	/** 男性を表す */
	public static final int MAN = 1;

	/** 女性を表す */
	public static final int WOMAN = 2;

	/** 最小部署ID */
	public static final int MIN_DEPT_ID = 1;

	/** 最大部署ID */
	public static final int MAX_DEPT_ID = 3;

	/** 社員ID、またはパスワードが間違っていた場合のエラーメッセージ */
	public static final String EMPID_OR_PASSWORD_MISMATCH = "社員ID、またはパスワードが間違っています。";

	/** 社員IDの桁数が5桁を超えた場合のチェックエラーメッセージ */
	public static final String USERID_LENGTH_OVER = "ユーザIDは20桁までで入力してください。";

	/** 社員IDが半角英数字以外で入力された場合のエラーメッセージ */
	public static final String USERID_MISSMATCH = "ユーザIDは半角英数字で入力してください。";

	/** 社員IDが未入力のエラーメッセージ */
	public static final String USERID_EMPTY = "ユーザIDを入力してください。";

	/** パスワードが未入力のエラーメッセージ */
	public static final String PASSWORD_EMPTY = "パスワードを入力してください。";

	/** パスワードの入力文字が15文字以上の場合のエラーメッセージ */
	public static final String PASSWORD_LENGTH_OVER = "パスワードは16文字以内で入力してください。";

	/** ユーザ名が未入力のエラーメッセージ */
	public static final String USER_NAME_EMPTY = "ユーザ名を入力してください。";

	/** ユーザ名の入力文字が30文字を超えた場合のエラーメッセージ */
	public static final String USER_NAME_LENGTH_OVER = "ユーザ名は30文字以内で入力してください。";

	/** 住所が未入力のエラーメッセージ */
	public static final String ADDRESS_EMPTY = "住所を入力してください。";

	/** 住所の入力文字が60文字を超えた場合のエラーメッセージ */
	public static final String ADDRESS_LENGTH_OVER = "住所は60文字以内で入力してください。";

	/** 生年月日が未入力のエラーメッセージ */
	public static final String BIRTHDAY_EMPTY = "生年月日を入力してください。";

	/** 生年月日の値が予期しない値時のエラーメッセージ */
	public static final String BIRTHDAY_MISSMATCH = "正しい日付を入力してください。";

	/** 電話番号が未入力のエラーメッセージ */
	public static final String TEL_EMPTY = "電話番号を入力してください。";

	/** 電話番号が数字でない場合のエラーメッセージ */
	public static final String TEL_MISMATCH = "電話番号は数字を入力してください。";

	/** 電話番号の入力文字が8文字でない場合のエラーメッセージ */
	public static final String TEL_LENGTH_MISMATCH = "電話番号は8字で入力してください。";

	/** 商品IDの桁数が5桁を超えた場合のチェックエラーメッセージ */
	public static final String PRODUCT_ID_LENGTH_OVER = "商品IDは60桁までで入力してください。";

	/** 商品IDが半角英数字以外で入力された場合のエラーメッセージ */
	public static final String PRODUCT_ID_MISSMATCH = "商品IDは半角英数字で入力してください。";

	/** 商品IDが未入力のエラーメッセージ */
	public static final String PRODUCT_ID_EMPTY = "商品IDを入力してください。";

	/** 商品名が未入力のエラーメッセージ */
	public static final String PRODUCT_NAME_EMPTY = "商品名を入力してください。";

	/** 商品名の入力文字が140文字を超えた場合のエラーメッセージ */
	public static final String PRODUCT_NAME_LENGTH_OVER = "商品名は140文字以内で入力してください。";

	/** 商品説明の入力文字が400文字を超えた場合のエラーメッセージ */
	public static final String PRODUCT_EXPLAIN_LENGTH_OVER = "商品説明は400文字以内で入力してください。";

	/** 商品の値段が未入力のエラーメッセージ */
	public static final String PRICE_EMPTY = "商品の値段を入力してください。";

	/** 商品の値段が数字でない場合のエラーメッセージ */
	public static final String PRICE_MISMATCH = "商品の値段は数字を入力してください。";

	/** 商品の値段の入力文字が140文字を超えた場合のエラーメッセージ */
	public static final String PRICE_LENGTH_OVER = "商品の値段は20桁以内で入力してください。";

	/** 商品の在庫が未入力のエラーメッセージ */
	public static final String STOCK_EMPTY = "商品の在庫を入力してください。";

	/** 商品の在庫が数字でない場合のエラーメッセージ */
	public static final String STOCK_MISMATCH = "商品の在庫は数字を入力してください。";

	/** 商品の在庫の入力文字が4文字を超えた場合のエラーメッセージ */
	public static final String STOCK_LENGTH_OVER = "商品の在庫は4桁以内で入力してください。";


}