package com.ArdModel;
//wakeup 테이블 wake_time 컬럼
public class wtVO {

int wt;

public wtVO(int wt) {
	super();
	this.wt = wt;
}

@Override
public String toString() {
	return "wtVO [wt=" + wt + "]";
}


}
