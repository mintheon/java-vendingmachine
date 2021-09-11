import domain.CoinBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("동전통 관련 기능 테스트")
public class CoinBoxTest {
    CoinBox coinBox;

    @BeforeEach
    void setup() {
        //coinBox = new CoinBox();
    }

//    @Test
//    @DisplayName("동전을 생성한다.")
//    void 동전_생성() {
//        CoinBox expectedCoinBox = new CoinBox();
//
//        assertThat(expectedCoinBox).isEqualTo(new CoinBox());
//    }

    @ParameterizedTest
    @DisplayName("자판기의 보유금액을 설정한다.")
    @CsvSource(value = {"450, 450", "800, 800"}, delimiter = ',')
    void 자판기의_보유금액_설정(int allAmount, int expectedAmount) {
        coinBox = CoinBox.charge(allAmount);

        assertThat(coinBox.total()).isEqualTo(expectedAmount);
    }

}
