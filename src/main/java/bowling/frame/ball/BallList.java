package bowling.frame.ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by naver on 2018. 11. 26..
 */
public class BallList {
	private final List<Ball> ballList;
	private int pinSum;
	private Ball beforeBall;

	public BallList() {
		ballList = new ArrayList<>();
	}

	public void add(int pinCount) {
		BallStatus ballStatus = computeBallStatus(pinCount);

		Ball ball = new Ball(pinCount, ballStatus);

		beforeBall = ball;

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

	private BallStatus computeBallStatus(int pinCount) {
		if(pinCount == Ball.MAX_PIN_COUNT) {
			return BallStatus.STRIKE;
		} else if(beforeBall != null) {
			if((beforeBall.getPinCount() + pinCount) == Ball.MAX_PIN_COUNT) {
				return BallStatus.SPARE;
			} else if(beforeBall.getBallStatus() == BallStatus.NONE) {
				return BallStatus.OPEN_FRAME;
			} else {
				return BallStatus.NONE;
			}
		}  else {
			return BallStatus.NONE;
		}
	}
}
