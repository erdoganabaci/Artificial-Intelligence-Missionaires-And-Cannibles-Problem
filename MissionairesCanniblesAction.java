package aima.gui.demo.search;

import aima.core.agent.impl.DynamicAction;

public class MissionairesCanniblesAction extends DynamicAction {
    public static final String GO_LEFT_M_M = "GO_LEFT_M_M";
    public static final String GO_LEFT_M_C = "GO_LEFT_M_C";
    public static final String GO_LEFT_C = "GO_LEFT_C";
    public static final String GO_LEFT_C_C = "GO_LEFT_C_C";
    public static final String GO_LEFT_M = "GO_LEFT_M";
    public static final String GO_RIGHT_M_M = "GO_RIGHT_M_M";
    public static final String GO_RIGHT_M_C = "GO_RIGHT_M_C";
    public static final String GO_RIGHT_C_C = "GO_RIGHT_C_C";
    public static final String GO_RIGHT_M = "GO_RIGHT_M";
    public static final String GO_RIGHT_C = "GO_RIGHT_C";

    public MissionairesCanniblesAction(String type) {
        super(type);
    }
}
