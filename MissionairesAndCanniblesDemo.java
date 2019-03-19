package aima.gui.demo.search;

import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;

public class MissionairesAndCanniblesDemo {

    public static void main(String[] args) {
        MissionairesAndCannibalsDemo();
    }

    private static void MissionairesAndCannibalsDemo() {
        //uninformed search algorithms
        MC_BFS(); // Breadth First Search
        MC_UCS(); // Uniform Cost Search
        MC_DLS(); // Depth Limited Search
        MC_IDLS(); // Iterative Deepening Search
         MS_DFS(); // Depth First Search

        //informed search algorithms
        MC_GreedyBestFirst(); // Greedy Best First Search
        MC_AStar(); // Astar Search
    }

    private static void MC_UCS() {
        System.out.println("\nMissionaires&Cannibals Demo Uniform Cost Search -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = new MissionairesCanniblesGeneralProblem(new MissonairesCanniblesEnvironment());
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new UniformCostSearch<>();
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MC_BFS() {
        System.out.println("\nMissionaires&Cannibals Demo BFS -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = MissionairesCanniblesProblem.createProblem();
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new BreadthFirstSearch<>(new TreeSearch<>());
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MS_DFS() {
        System.out.println("\nMissionaires&Cannibals Demo DFS -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = MissionairesCanniblesProblem.createProblem();
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new DepthFirstSearch<>(new GraphSearch<>());
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MC_DLS() {
        System.out.println("\nMissionaires&Cannibals Demo Depth Limited Search -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = new MissionairesCanniblesGeneralProblem(new MissonairesCanniblesEnvironment());
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new DepthLimitedSearch<>(9);
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MC_IDLS() {
        System.out.println("\nMissionaires&Cannibals Demo Iterative DLS Search -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = new MissionairesCanniblesGeneralProblem(new MissonairesCanniblesEnvironment(2, 1, 2, 1, 0, 1));
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new IterativeDeepeningSearch<>();
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MC_GreedyBestFirst() {
        System.out.println("\nMissionaires&Cannibals Demo Greedy Best First Search -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = new MissionairesCanniblesGeneralProblem(new MissonairesCanniblesEnvironment());
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new GreedyBestFirstSearch<>
                    (new GraphSearch<>(), MissionairesCanniblesProblem.myHeuristicFunction());
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    private static void MC_AStar() {
        System.out.println("\nMissionaires&Cannibals AStar Search -->");
        try {
            Problem<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> problem = new MissionairesCanniblesGeneralProblem(new MissonairesCanniblesEnvironment());
            SearchForActions<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> search = new AStarSearch<>
                    (new GraphSearch<>(), MissionairesCanniblesProblem.myHeuristicFunction());
            SearchAgent<MissonairesCanniblesEnvironment, MissionairesCanniblesAction> agent = new SearchAgent<>(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInstrumentation(Properties properties) {
        for (Object o : properties.keySet()) {
            String key = (String) o;
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List<Action> actions) {
        for (Action action : actions) {
            System.out.println(action.toString());
        }
    }

}