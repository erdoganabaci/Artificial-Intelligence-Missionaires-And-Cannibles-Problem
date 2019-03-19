package aima.gui.demo.search;

import aima.core.search.framework.problem.BidirectionalProblem;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;

public class MissionairesCanniblesGeneralProblem extends GeneralProblem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> implements BidirectionalProblem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> {

    private final Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> getProblem;

    public MissionairesCanniblesGeneralProblem(MissonairesCanniblesEnvironment initialState) {
        super(initialState, MissionairesCanniblesProblem::getActions, MissionairesCanniblesProblem::getResult, MissonairesCanniblesEnvironment::isResultOk);
        getProblem = new GeneralProblem<>(new MissonairesCanniblesEnvironment(0,3,0,3,0,1), MissionairesCanniblesProblem::getActions, MissionairesCanniblesProblem::getResult, MissonairesCanniblesEnvironment::isResultOk);
    }

    public Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> getRealProblem() {
        return this;
    }

    public Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> getReverseProblem() {
        return getProblem;
    }
}

