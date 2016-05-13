package server;

public class AgentTesting {
	public static void main(String[] args){
		Agent testAgent = new Agent();
		testAgent.stats.defaultStats();
		testAgent.swapClass(CharClass.setClass("archer"));
		System.out.println(testAgent.stats.printStats());
	}
}
