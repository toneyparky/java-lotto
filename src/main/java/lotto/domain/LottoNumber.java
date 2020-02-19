package lotto.domain;

import java.util.Arrays;

/**
 * 로또번호 상수들에 대한 enum
 *
 * @author 토니, 히히
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/18
 */
public enum LottoNumber {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	ELEVEN(11),
	TWELVE(12),
	THIRTEEN(13),
	FOURTEEN(14),
	FIFTEEN(15),
	SIXTEEN(16),
	SEVENTEEN(17),
	EIGHTEEN(18),
	NINETEEN(19),
	TWENTY(20),
	TWENTY_ONE(21),
	TWENTY_TWO(22),
	TWENTY_THREE(23),
	TWENTY_FOUR(24),
	TWENTY_FIVE(25),
	TWENTY_SIX(26),
	TWENTY_SEVEN(27),
	TWENTY_EIGHT(28),
	TWENTY_NINE(29),
	THIRTY(30),
	THIRTY_ONE(31),
	THIRTY_TWO(32),
	THIRTY_THREE(33),
	THIRTY_FOUR(34),
	THIRTY_FIVE(35),
	THIRTY_SIX(36),
	THIRTY_SEVEN(37),
	THIRTY_EIGHT(38),
	THIRTY_NINE(39),
	FORTY(40),
	FORTY_ONE(41),
	FORTY_TWO(42),
	FORTY_THREE(43),
	FORTY_FOUR(44),
	FORTY_FIVE(45);

	private final int lottoNumber;

	LottoNumber(final int inputLottoNumber) {
		this.lottoNumber = inputLottoNumber;
	}

	public static LottoNumber of(final int inputLottoNumber) {
		return Arrays.stream(LottoNumber.values())
				.filter(value -> value.lottoNumber == inputLottoNumber)
				.findFirst()
				.orElseThrow(() -> new WrongLottoNumberException("유효한 로또 번호가 아닙니다."));
	}
}
