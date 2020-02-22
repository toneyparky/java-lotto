package lotto.view;

import lotto.domain.*;
import lotto.util.StringUtils;

import java.util.List;
import java.util.Scanner;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/20
 */
public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static String getMoneyForLotto() {
		OutputView.askEnterMoneyForLotto();
		return SCANNER.nextLine();
	}

	public static String getWinningLotto() {
		OutputView.askEnterWinningLotto();
		return SCANNER.nextLine();
	}

	public static String getBonusLottoNumber() {
		OutputView.askEnterBonusLottoNumber();
		return SCANNER.nextLine();
	}
}
