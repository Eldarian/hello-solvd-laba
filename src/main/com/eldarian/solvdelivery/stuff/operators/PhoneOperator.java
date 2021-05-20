package com.eldarian.solvdelivery.stuff;

public class PhoneOperator extends Operator {

    public PhoneOperator(Manager manager) {
        super(manager);
    }

    @Override
    public void getRequest(int requestId) {
        manager.getRequest(requestId);
    }
}
