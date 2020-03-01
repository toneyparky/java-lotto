package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * LottoFactory 테스트
 *
 * @author 토니, 히히
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/19
 */
public class LottoFactoryTest {
	@Test
	void createAutoLotto_올바른_동작_확인() {
		assertThat(LottoFactory.createAutoLotto())
				.isInstanceOf(Lotto.class);
	}

	@Test
	void createManualLotto_올바른_동작_확인() {
		List<LottoNumber> manualLottoNumber = Arrays.asList(
				LottoNumber.of(1),
				LottoNumber.of(2),
				LottoNumber.of(3),
				LottoNumber.of(4),
				LottoNumber.of(5),
				LottoNumber.of(6)
		);

		assertThat(LottoFactory.createManualLotto(manualLottoNumber))
				.isInstanceOf(Lotto.class);
	}

	@Test
	void createManualLotto_중복된_로또번호_예외처리() {
		List<LottoNumber> winningLottoNumbers = Arrays.asList(
				LottoNumber.of(1),
				LottoNumber.of(2),
				LottoNumber.of(3),
				LottoNumber.of(4),
				LottoNumber.of(5),
				LottoNumber.of(5)
		);

		assertThatThrownBy(() -> {
			LottoFactory.createManualLotto(winningLottoNumbers);
		}).isInstanceOf(InvalidLottoException.class)
				.hasMessage("입력 로또번호에 중복이 있습니다.");
	}
}
