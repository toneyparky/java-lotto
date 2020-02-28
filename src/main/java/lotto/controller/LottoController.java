package lotto.controller;

import java.util.List;

import lotto.domain.lotto.*;
import lotto.domain.lottostore.LottoStore;
import lotto.domain.money.MoneyForLotto;
import lotto.domain.result.ResultStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 로또 실행을 담당, View와 Domain을 연결
 *
 * @author 토니, 히히
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/20
 */
public class LottoController {
	public void run() {
		MoneyForLotto moneyForLotto = new MoneyForLotto(InputView.getMoneyForLotto());
		LottoCount lottoCount = new LottoCount(moneyForLotto.calculateAmountOfLottos(), InputView.getManualLottoCount());

		LottoStore lottoStore = new LottoStore();
		List<String> inputManualLottoNumbers = InputView.getManualLottoNumbers(lottoCount.getManualLottoCount());
		Lottos purchasedLottos = lottoStore.buy(lottoCount, inputManualLottoNumbers);
		OutputView.printPurchasedLottos(lottoCount, purchasedLottos);

		String inputWinningLottoNumbers = InputView.getWinningLotto();
		String inputBonusLottoNumber = InputView.getBonusLottoNumber();
		WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumbers, inputBonusLottoNumber);

		ResultStatistic result = ResultStatistic.calculate(purchasedLottos, winningLotto);
		OutputView.printResultStatistic(result, moneyForLotto);
	}
}
