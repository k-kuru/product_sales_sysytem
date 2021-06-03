package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Product;
import bean.User;

/**
 * エラーに関する処理をまとめたクラス
 */
public class Validator {

	/** インスタンス化を禁止 */
	private Validator() {
	}

	/**
	 * 未入力のチェックを行うメソッド
	 *
	 * @param val チェック対象
	 * @return true(空)
	 *         false(空でない)
	 */
	public static boolean isEmpty(String val) {
		if (val == null || val.isEmpty()) {
			return true;
		} else  {
			return false;
		}
	}

	/**
	 * 数値かどうかのチェックを行うメソッド
	 *
	 * @param val チェック対象
	 * @return true(数値)
	 *         false(数値でない)
	 */
	public static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 半角英数字かどうかチェックを行うメソッド
	 *
	 * @param target チェック対象
	 * @return true(半角英数字)
	 * 			false(半角英数字でない)
	 */
	public static boolean isNumberOrAlphabet(String target) {
		boolean result = true;

		// 引数に指定した正規表現regexがtargetにマッチするか確認する
		Pattern p1 = Pattern.compile("^[A-Za-z0-9]+$"); // 正規表現パターンの読み込み
		Matcher m1 = p1.matcher(target); // パターンと検査対象文字列の照合
		result = m1.matches(); // 照合結果をtrueかfalseで取得
		return result;
	}

	/**
	 * 指定した桁数を超えているかチェックを行うメソッド
	 *
	 * @param val
	 *        digit
	 * @return true(桁数を超えている)
	 *         false(桁数を超えていない)
	 */
	public static boolean overLength(String val, int digit) {
		if (val.length() > digit) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 日付の妥当性チェック
	 *
	 * @param val
	 * @return true(正しい日付)
	 *         false(誤った日付)
	 */
	public static boolean isDate(String val) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format.setLenient(false);
			format.parse(val);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}


	/**
	 * ログイン画面におけるID,パスワードの入力チェック
	 * ログイン画面に表示するエラーメッセージのリストを作成
	 *
	 * @param id
	 *        password
	 * @return エラーメッセージのリスト
	 */
	public static List<String> makeLoginErrorMessageList(String id, String password) {
		List<String> errorMessageList = new ArrayList<String>();

		// ****** idのチェック ******
		// 未入力チェック
		if (isEmpty(id)) {
			errorMessageList.add(Constants.USERID_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(id, 20)) {
				errorMessageList.add(Constants.USERID_LENGTH_OVER);
				// 数値チェック
			} else if (isNumberOrAlphabet(id)) {
				errorMessageList.add(Constants.USERID_MISSMATCH);
			}
		}

		// ****** パスワードのチェック ******
		// 未入力チェック
		if (isEmpty(password)) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(password, 16)) {
				errorMessageList.add(Constants.PASSWORD_LENGTH_OVER);
			}
		}

		return errorMessageList;
	}

	/**
	 * ユーザ登録(更新)入力画面に表示するエラーメッセージのリストを作成するメソッド
	 *
	 * @param employeeBean
	 * @return エラーメッセージのリスト
	 */
	public static List<String> makeUserInputErrorMessageList(User userBean) {
		List<String> errorMessageList = new ArrayList<String>();

		// ****** ユーザIDのチェック ******
		// 未入力チェック
		if (isEmpty(userBean.getUserId())) {
			errorMessageList.add(Constants.USERID_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(userBean.getUserId(), 20)) {
				errorMessageList.add(Constants.USERID_LENGTH_OVER);
				// 数値チェック
			} else if (isNumberOrAlphabet(userBean.getUserId())) {
				errorMessageList.add(Constants.USERID_MISSMATCH);
			}
		}

		// ****** パスワードのチェック ******
		// 未入力チェック
		if (isEmpty(userBean.getPass())) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(userBean.getPass(), 16)) {
				errorMessageList.add(Constants.PASSWORD_LENGTH_OVER);
			}
		}

		// ****** ユーザ名のチェック ******
		// 未入力チェック
		if (isEmpty(userBean.getUserName())) {
			errorMessageList.add(Constants.USER_NAME_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(userBean.getUserName(), 30)) {
				errorMessageList.add(Constants.USER_NAME_LENGTH_OVER);
			}
		}

		// ****** 住所のチェック ******
		// 未入力チェック
		if (isEmpty(userBean.getAddress())) {
			errorMessageList.add(Constants.ADDRESS_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(userBean.getAddress(), 60)) {
				errorMessageList.add(Constants.ADDRESS_LENGTH_OVER);
			}
		}

		// ****** 生年月日のチェック ******
		// 未入力チェック
		if (isEmpty(userBean.getBirthDay())) {
			errorMessageList.add(Constants.BIRTHDAY_EMPTY);
		} else {
			// 日付の妥当性チェック
			if (!isDate(userBean.getBirthDay())) {
				errorMessageList.add(Constants.BIRTHDAY_MISSMATCH);
			}
		}

		// ****** 電話番号のチェック ******
		// 未入力チェック
		if (String.valueOf(userBean.getTel()).length() == 0) {
			errorMessageList.add(Constants.TEL_EMPTY);
		} else {
			// 桁数チェック
			if (String.valueOf(userBean.getTel()).length() != 11) {
				errorMessageList.add(Constants.TEL_LENGTH_MISMATCH);
			}
		}

		return errorMessageList;
	}

	public static List<String> makeProductInputErrorMessageList(Product productBean) {
		List<String> errorMessageList = new ArrayList<String>();

		// ****** 商品IDのチェック ******
		// 未入力チェック
		if (isEmpty(productBean.getProductId())) {
			errorMessageList.add(Constants.PRODUCT_ID_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(productBean.getProductId(), 60)) {
				errorMessageList.add(Constants.PRODUCT_ID_LENGTH_OVER);
				// 数値チェック
			} else if (isNumberOrAlphabet(productBean.getProductId())) {
				errorMessageList.add(Constants.PRODUCT_ID_MISSMATCH);
			}
		}

		// ****** 商品名のチェック ******
		// 未入力チェック
		if (isEmpty(productBean.getProductName())) {
			errorMessageList.add(Constants. PRODUCT_NAME_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(productBean.getProductName(), 140)) {
				errorMessageList.add(Constants.PRODUCT_NAME_LENGTH_OVER);
			}
		}

		// ****** 商品説明のチェック ******
		// 桁数チェック
		if (overLength(productBean.getProductExplain(), 60)) {
			errorMessageList.add(Constants.ADDRESS_LENGTH_OVER);
		}

		// ****** 商品の値段のチェック ******
		// 未入力チェック
		if (String.valueOf(productBean.getPrice()).length() == 0) {
			errorMessageList.add(Constants.BIRTHDAY_EMPTY);
		} else {
			// チェック
			if (String.valueOf(productBean.getPrice()).length() > 20) {
				errorMessageList.add(Constants.BIRTHDAY_MISSMATCH);
			}
		}

		// ****** 在庫数のチェック ******
		// 未入力チェック
		if (String.valueOf(productBean.getStock()).length() == 0) {
			errorMessageList.add(Constants.TEL_EMPTY);
		} else {
			// 桁数チェック
			if (String.valueOf(productBean.getStock()).length() != 11) {
				errorMessageList.add(Constants.TEL_LENGTH_MISMATCH);
			}
		}

		return errorMessageList;
	}
}
