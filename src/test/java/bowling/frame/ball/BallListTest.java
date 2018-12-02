package bowling.frame.ball;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by naver on 2018. 12. 2..
 */
public class BallListTest {
	@Test
	public void strike_1() {
		BallList ballList = new BallList();

		ballList.add(10);
		ballList.add(1);

		List<BallStatus> ballStatusList = statusList(ballList);

		assertEquals(ballStatusList.get(0), BallStatus.STRIKE);
		assertEquals(ballStatusList.get(1), BallStatus.NONE);
	}

	@Test
	public void strike_2() {
		BallList ballList = new BallList();

		ballList.add(10);
		ballList.add(10);

		List<BallStatus> ballStatusList = statusList(ballList);

		assertEquals(ballStatusList.get(0), BallStatus.STRIKE);
		assertEquals(ballStatusList.get(1), BallStatus.STRIKE);
	}

	@Test
	public void spare() {
		int maxPin = 10;
		for(int i = 1; i < 10; i++) {
			BallList ballList = new BallList();

			ballList.add(i);
			ballList.add(maxPin-i);

			List<BallStatus> ballStatusList = statusList(ballList);

			assertEquals(ballStatusList.get(0), BallStatus.NONE);
			assertEquals(ballStatusList.get(1), BallStatus.SPARE);
		}
	}

	@Test
	public void openFrame() {
		int underMaxPin = 9;
		for(int i = 0; i < 10; i++) {
			BallList ballList = new BallList();

			ballList.add(i);
			ballList.add(underMaxPin-i);

			List<BallStatus> ballStatusList = statusList(ballList);

			assertEquals(ballStatusList.get(0), BallStatus.NONE);
			assertEquals(ballStatusList.get(1), BallStatus.OPEN_FRAME);
		}
	}

	private List<BallStatus> statusList(BallList ballList) {
		return ballList.getBallList().stream()
			.map(Ball::getBallStatus)
			.collect(Collectors.toList());
	}
}
