package bowling.frame;

import bowling.frame.ball.BallList;
import lombok.AllArgsConstructor;

/**
 * Created by naver on 2018. 11. 26..
 */
@AllArgsConstructor
public class FrameImpl implements Frame{

	private final BallList ballList;

	public FrameImpl() {
		ballList = new BallList();
	}

	@Override
	public boolean addBall(int pinCount) {
		checkAndThrow(pinCount);

		if(needNext()) {
			getBallList().add(pinCount);

			return needNext();
		}

		return false;
	}

	protected final BallList getBallList() {
		return ballList;
	}

	protected boolean needNext() {
		return ballList.getPinSum() < 10 && ballList.getBallCount() < 2;
	}

	protected void checkAndThrow(int pinCount) {
		if(ballList.getBallCount() == 2) {
			throw new IllegalStateException("over bowling.frame ball count");
		}
		if(ballList.getPinSum() + pinCount > 10) {
			throw new IllegalStateException("over bowling.frame pin count");
		}
	}
}
