package bowling.frame;

import bowling.frame.ball.Ball;
import bowling.frame.ball.BallStatus;

import java.util.List;

/**
 * Created by naver on 2018. 11. 26..
 */
public class TenthFrame extends FrameImpl {

	@Override
	protected boolean needNext() {
		if(getBallList().getBallCount() < 2) {
			return true;
		} else {
			return needBonusBall(getBallList().getBallList());
		}
	}

	private boolean needBonusBall(List<Ball> ballList) {
		return ballList.size() == 2 && ballList.stream()
			.map(Ball::getBallStatus)
			.anyMatch(this::bonusBall);
	}

	private boolean bonusBall(BallStatus ballStatus) {
		return ballStatus == BallStatus.STRIKE || ballStatus == BallStatus.SPARE;
	}

	@Override
	protected void checkAndThrow(int pinCount) {
		if(needBonusBall(getBallList().getBallList())) {
			if(getBallList().getBallCount() >= 3) {
				throw new IllegalStateException("over bowling.frame ball count");
			} else if(getBallList().getPinSum() + pinCount > 30) {
				throw new IllegalStateException("over bowling.frame pin count");
			}
		} else {
			if(getBallList().getBallCount() >= 2) {
				throw new IllegalStateException("over bowling.frame ball count");
			} else if(getBallList().getPinSum() + pinCount > 20) {
				throw new IllegalStateException("over bowling.frame pin count");
			}
		}
	}

}
