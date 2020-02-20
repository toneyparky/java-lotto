package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/20
 */
public class OutputView {
	private static final String ENTER_MONEY_FOR_LOTTO_GUIDE_MESSAGE = "구매금액을 입력해 주세요.";
	private static final String PURCHASED_LOTTO_NUMBER_IS = "%d개를 구매했습니다.\n";
	private static final String ENTER_WINNING_LOTTO_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String ENTER_BONUS_BALL_NUMBER_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.\n";
	public static final String RESULT_STATISTIC_MESSAGE = "당첨 통계\n--------";

	public static void askEnterMoneyForLotto() {
		System.out.println(ENTER_MONEY_FOR_LOTTO_GUIDE_MESSAGE);
	}

	public static void printExceptionMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

	public static void printPurchasedLottos(int numberOfLottos, Lottos lottos) {
		System.out.printf(PURCHASED_LOTTO_NUMBER_IS, numberOfLottos);

		List<String> purchasedLottos = new ArrayList<>();
		for (Lotto lotto : lottos.getLottos()) {
			purchasedLottos.add(lotto.getLottoNumbers()
					.stream()
					.map(LottoNumber::getLottoNumber)
					.map(Object::toString)
					.collect(Collectors.joining(", "))
			);
		}
		for (String purchasedLotto : purchasedLottos) {
			System.out.println("[" + purchasedLotto + "]");
		}
	}


	public static void askEnterWinningLotto() {
		System.out.println(ENTER_WINNING_LOTTO_GUIDE_MESSAGE);
	}

	public static void askEnterBonusLottoNumber() {
		System.out.println(ENTER_BONUS_BALL_NUMBER_GUIDE_MESSAGE);
	}

	public static void printResultStatistic(ResultStatistic result) {
		System.out.println(RESULT_STATISTIC_MESSAGE);
		printEachRankResult(Rank.FIFTH, result);
		printEachRankResult(Rank.FOURTH, result);
		printEachRankResult(Rank.THIRD, result);
		printEachRankResult(Rank.SECOND, result);
		printEachRankResult(Rank.FIRST, result);
	}


	private static void printEachRankResult(Rank rank, ResultStatistic result) {
		System.out.printf("%d개 일치 (%d원)- %d개\n",
				rank.getMatchCounts().get(0),
				rank.getReward(),
				result.getResults().get(rank)
		);
	}
}
