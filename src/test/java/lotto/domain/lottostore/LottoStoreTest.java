package lotto.domain.lottostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.lotto.InvalidLottosException;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.Lottos;

/**
 * LottoStore 테스트
 *
 * @author 토니, 히히
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/28
 */
public class LottoStoreTest {
	private LottoStore lottoStore;

	@BeforeEach
	void setUp() {
		lottoStore = new LottoStore();
	}

	@Test
	void buy_수동_2장_자동_2장_구매_성공() {
		LottoCount lottoCount = new LottoCount(4, "2");
		List<String> inputManualLottoNumbers = Arrays.asList(
				"1,2,3,4,5,6",
				"7,8,9,42,12,31"
		);
		assertThat(lottoStore.buy(lottoCount, inputManualLottoNumbers)).isInstanceOf(Lottos.class);
	}

	@Test
	void buy_수동_구매_장수와_실제_수동_입력_장수_차이로_예외_발생() {
		LottoCount lottoCount = new LottoCount(4, "3");
		List<String> inputManualLottoNumbers = Arrays.asList(
				"1,2,3,4,5,6",
				"7,8,9,42,12,31"
		);
		assertThatThrownBy(() -> {
			lottoStore.buy(lottoCount, inputManualLottoNumbers);
		}).isInstanceOf(InvalidLottosException.class)
				.hasMessage("구매하려는 수동 장수와 입력 수동 장수가 맞지 않습니다.");
	}

}
