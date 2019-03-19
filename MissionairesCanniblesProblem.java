package aima.gui.demo.search;

import aima.core.agent.Action;
import aima.core.search.framework.Node;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

public class MissionairesCanniblesProblem {
	
	/**
	   Provides useful function of the MissionariesCanniblesProblem. The
  	   createProblem formulation and the complete-state formulation
  	   */

    public static Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> createProblem() {
        return new GeneralProblem<>(new MissonairesCanniblesEnvironment(), MissionairesCanniblesProblem::getActions, MissionairesCanniblesProblem::getResult, MissionairesCanniblesProblem::testGoal);
    }
    /**
     * Implements an ACTIONS function for the createProblem formulation of the
     * MissionariesCanniblesProblem.
     * <p>
     * Assumes that MissionairesAndCannibles are placed , starting with an empty
     * boat, and provides MissionairesAndCannibles placing actions for all non-placed positions
     * of the boat and we checked states if state ok , we adding listActions.We checked five times,because we have 5 possible action to reach myState.
     */
    public static List<MissionairesCanniblesAction> getActions(MissonairesCanniblesEnvironment myState) {  
        List<MissionairesCanniblesAction> listActions = new ArrayList<>();
        MissionairesCanniblesAction myAct;
        boolean isLeft = myState.getB1() == 1;
        for (int i = 0; i < 5; i++) {
            String myActs = "";  
                if(i==4) {
                    myActs = isLeft ? MissionairesCanniblesAction.GO_RIGHT_M_C : MissionairesCanniblesAction.GO_LEFT_M_C;
                    }
                if(i==3) {
                    myActs = isLeft ? MissionairesCanniblesAction.GO_RIGHT_M_M : MissionairesCanniblesAction.GO_LEFT_M_M;
                }
                if(i==2) {
                    myActs = isLeft ? MissionairesCanniblesAction.GO_RIGHT_C_C : MissionairesCanniblesAction.GO_LEFT_C_C;
                }
                if(i==1) {
                    myActs = isLeft ? MissionairesCanniblesAction.GO_RIGHT_C : MissionairesCanniblesAction.GO_LEFT_C;  
                }
                if(i==0) {
                    myActs = isLeft ? MissionairesCanniblesAction.GO_RIGHT_M : MissionairesCanniblesAction.GO_LEFT_M;
                }
            myAct = new MissionairesCanniblesAction(myActs);
            MissonairesCanniblesEnvironment newLocation = getResult(myState, myAct);
            if (newLocation.isStateOk()) {
                listActions.add(myAct);
            }
        }
        return listActions;
    }
    /**
     * Implements a RESULT function for the MissionairesAndCannibles.
     * Supports MissionairesAndCannibles placing,and MissionairesAndCannibles movement actions.
     */
    public static MissonairesCanniblesEnvironment getResult(MissonairesCanniblesEnvironment state, MissionairesCanniblesAction action) {
        MissonairesCanniblesEnvironment result = state.clone();

        if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_RIGHT_C)) {
            result.setC1(result.getC1() - 1);
            result.setC2(result.getC2() + 1);
            result.setB1(0);
            result.setB2(1);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_LEFT_C)) {
            result.setC1(result.getC1() + 1);
            result.setC2(result.getC2() - 1);
            result.setB1(1);
            result.setB2(0);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_LEFT_M)) {
            result.setM1(result.getM1() + 1);
            result.setM2(result.getM2() - 1);
            result.setB1(1);
            result.setB2(0);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_RIGHT_M)) {
            result.setM1(result.getM1() - 1);
            result.setM2(result.getM2() + 1);
            result.setB1(0);
            result.setB2(1);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_RIGHT_C_C)) {
            result.setC1(result.getC1() - 2);
            result.setC2(result.getC2() + 2);
            result.setB1(0);
            result.setB2(1);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_RIGHT_M_M)) {
            result.setM1(result.getM1() - 2);
            result.setM2(result.getM2() + 2);
            result.setB1(0);
            result.setB2(1);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_LEFT_C_C)) {
            result.setC1(result.getC1() + 2);
            result.setC2(result.getC2() - 2);
            result.setB1(1);
            result.setB2(0);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_LEFT_M_M)) {
            result.setM1(result.getM1() + 2);
            result.setM2(result.getM2() - 2);
            result.setB1(1);
            result.setB2(0);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_LEFT_M_C)) {
            result.setM1(result.getM1() + 1);
            result.setM2(result.getM2() - 1);
            result.setC1(result.getC1() + 1);
            result.setC2(result.getC2() - 1);
            result.setB1(1);
            result.setB2(0);
        } else if (Objects.equals(action.getName(), MissionairesCanniblesAction.GO_RIGHT_M_C)) {
            result.setM1(result.getM1() - 1);
            result.setM2(result.getM2() + 1);
            result.setC1(result.getC1() - 1);
            result.setC2(result.getC2() + 1);
            result.setB1(0);
            result.setB2(1);
        }

        return result;
    }
    /**
     * Implements a GOAL-TEST for the MissionairesAndCannibles problem.This function checked state whether state reach testGoal.
     */
    public static boolean testGoal(MissonairesCanniblesEnvironment state) {
        return state.isResultOk();
    }

    /**
     * Estimates the distance to goal by the number of positon pairs of MissionairesAndCannibles on
     * the boat.
     */
    public static ToDoubleFunction<Node<MissonairesCanniblesEnvironment, MissionairesCanniblesAction>> myHeuristicFunction() {
        return new HeuristicFunction();
    }

    private static class HeuristicFunction implements ToDoubleFunction<Node<MissonairesCanniblesEnvironment, MissionairesCanniblesAction>> {

        public double applyAsDouble(Node<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> node) {
            MissonairesCanniblesEnvironment board = node.getState();
            return getNumberOfMisplacedTiles(board);
        }
        /**
         * Implements a GOAL-TEST condition for the MissionairesAndCannibles problem.
         */
        private int getNumberOfMisplacedTiles(MissonairesCanniblesEnvironment state) {
            return 2 - state.getM2() + 2 - state.getC2() + 1 - state.getB2();
        }
    }
  
}
