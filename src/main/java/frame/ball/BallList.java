package frame.ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by naver on 2018. 11. 26..
 */
public class BallList {
	private final List<Ball> ballList;
	private int pinSum;

	public BallList() {
		ballList = new ArrayList<>();
	}

	public void add(Ball ball) {
		ballList.add(ball);
		pinSum += ball.getPinCount();
	}

	public int getPinSum() {
		return pinSum;
	}

	public int getBallCount() {
		return ballList.size();
	}

	public List<Ball> getBallList() {
		return Collections.unmodifiableList(ballList);
	}
}
