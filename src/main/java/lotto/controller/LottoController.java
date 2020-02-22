package lotto.controller;

import lotto.domain.*;
import lotto.util.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoFactory;

/**
 * 클래스 이름 : LottoController.java
 *
 * @author 토니, 히히
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/20
 */
public class LottoController { // TODO 변수들을 클래스변수로 뺴고 메서드들을 나누기
	public static void run() {
		MoneyForLotto moneyForLotto = receiveMoneyForLotto(); // TODO 로또 인풋 받는 메서드
		int amountOfLottos = moneyForLotto.calculateAmountOfLottos();
		Lottos lottos = LottosFactory.createLottosAuto(amountOfLottos);
		OutputView.printPurchasedLottos(amountOfLottos, lottos);

		WinningLotto winningLotto = receiveWinningLotto(); // TODO 결과 뽑는 메서드
		BonusLottoNumber bonusLottoNumber = receiveBonusLottoNumber(winningLotto);

		ResultStatistic result = ResultStatistic.calculate(lottos, winningLotto, bonusLottoNumber);
		OutputView.printResultStatistic(result, moneyForLotto); // TODO 여기까지 결과 뽑는 메서드
	}

	private static MoneyForLotto receiveMoneyForLotto() {
		try {
			return new MoneyForLotto(InputView.getMoneyForLotto());
		} catch (Exception e) {
			OutputView.printExceptionMessage(e);
			return receiveMoneyForLotto();
		}
	}

	private static WinningLotto receiveWinningLotto() {
		try {
			String inputWinningLotto = InputView.getWinningLotto();
			return (WinningLotto) LottoFactory.createLottoManual(
					LottoType.WINNING_LOTTO,
					StringUtils.splitIntoLottoNumbers(inputWinningLotto)
			);
		} catch (Exception e) {
			OutputView.printExceptionMessage(e);
			return receiveWinningLotto();
		}
	}

	private static BonusLottoNumber receiveBonusLottoNumber(WinningLotto winningLotto) {
		try {
			String inputBonusLottoNumber = InputView.getBonusLottoNumber();
			return new BonusLottoNumber(Integer.parseInt(inputBonusLottoNumber), winningLotto);
		} catch (Exception e) {
			OutputView.printExceptionMessage(e);
			return receiveBonusLottoNumber(winningLotto);
		}
	}
}
