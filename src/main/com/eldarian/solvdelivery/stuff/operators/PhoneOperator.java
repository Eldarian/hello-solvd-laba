package com.eldarian.solvdelivery.stuff.operators;

import com.eldarian.solvdelivery.stuff.Manager;

public class PhoneOperator extends Operator {

    public PhoneOperator(Manager manager) {
        super(manager);
    }

    @Override
    public void getRequest(int requestId) {
        manager.getRequest(requestId);
    }
}
