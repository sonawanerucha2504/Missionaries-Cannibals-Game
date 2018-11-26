package algogame;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	//this is the main method in the Missionaries and cannibals problem using various Search Strategies//

	public static void main(String[] args) {
		boolean a = true;
		while(a)
		{
		System.out.println("\n----- Missionaries and Cannibals Problem -----\n");
		System.out.println("Choose the search method: ");
		System.out.println("\t 1. Breadth-first search algorithm");
		System.out.println("\t 2. Depth-limited search algorithm");
		System.out.println("\t 3. Depth-First search algorithm");
		System.out.println("\t 4. Quit");
		System.out.print("\nType your choice and press ENTER: ");

	
		Scanner in = new Scanner(System.in);
		int casein = in.nextInt();
		State initialState = new State (3, 3, Position.LEFT, 0, 0);
		switch(casein)
		{
		case 1:
			long startTime = System.currentTimeMillis();
			BFS(initialState);
			long estimatedTime = System.currentTimeMillis() - startTime;
			System.out.println("The time is: " + estimatedTime);
			break;
		case 2:
			long startTime1 = System.currentTimeMillis();
			DLS(initialState);
			long estimatedTime1 = System.currentTimeMillis() - startTime1;
			System.out.println("The time is: " + estimatedTime1);

			break;
		case 3: 
			DFS(initialState);
			break;
		case 4:
			a=false;
			break;
		default:
			System.out.println("Invalid - Please select correct option");
		}
		}
	}
	


	//Calling the BFS method class by creating an object of it//
	private static void BFS(State initialState)
	{ 
		Breadthfirstsearch s1 = null;
		
		if(s1 == null)
		{
			s1 = new Breadthfirstsearch();	
		}
		State solution = s1.execBFS(initialState);
		printSolution(solution);
	}
	//Calling the DLS method class by creating an object of it//
	private static void DLS(State initialState)
	{
		Depthlimitedsearch s2 = null; 
		
		if(s2 == null)
		{
			s2 = new Depthlimitedsearch();
		}
		State solution = s2.execDLS(initialState);
		printSolution(solution);
	}
	//Calling the DFS method class by creating an object of it//
	private static void DFS(State initialState)
	{
		Depthfirstsearch d1 = null;
		
		if(d1==null)
		{
			d1=new Depthfirstsearch();
		}
		
		State solution = d1.execDFS(initialState);
		printSolution(solution);
	}

	//Printing the solutions//
	private static void printSolution(State solution) 
	{ 
		if (null == solution)
		{
			System.out.print("\n No solution found.");
		}
		else
		{
			List<State> path = new ArrayList<State>();
			State state = solution;
			while(null!=state)
			{
				path.add(state);
				state = state.getParentState();
			}

			int depth = path.size() - 1;
			for (int i = depth; i >= 0; i--)
			{
				state = path.get(i);
				if (state.isGoal())
				{
					System.out.print("\n" + state.toString());
				}
				else
				{
					System.out.print("\n" + state.toString());
				}
			}
			System.out.println();
			System.out.println("\nSolution found with depth: "+ depth);
		}
	}
}