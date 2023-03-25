// 06
package com.shinhan.day05;

public class Radio implements Volume {
	int volLevel;

	@Override
	public void volumeUp(int level) {
		// VolLevel 을 주어진 level 만큼 증가, 메시지 출력
		volLevel += level;
		System.out.println(getClass().getSimpleName() + " 볼륨 올립니다. " + volLevel);
	}

	@Override
	public void volumeDown(int level) {
		// VolLevel 을 주어진 level 만큼 감소, 메시지 출력
		volLevel -= level;
		System.out.println(getClass().getSimpleName() + " 볼륨 내립니다. " + volLevel);
	}

}
