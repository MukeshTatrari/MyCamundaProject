package com.mukesh.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ReserveSeatOnPlaneError implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money = "0.0";
        String ticketType = "Coach";

        money = (String) delegateExecution.getVariable("money");
        double moneyDouble = Double.parseDouble(money);

        if (moneyDouble >= 10000) {
            ticketType = "First Class";
        } else if (moneyDouble >= 5000) {
            ticketType = "Business Class";
        } else if (moneyDouble <= 100){
            ticketType = "Stowaway Class";
            throw new BpmnError("Not_Enough_Cash", "You do not have Enough Cash for your Trip.");
        }

        delegateExecution.setVariable("ticketType", ticketType);

    }
}
