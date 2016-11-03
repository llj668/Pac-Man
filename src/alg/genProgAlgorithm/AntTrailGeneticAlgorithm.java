package alg.genProgAlgorithm;

import alg.Map;
import alg.chromosome.AntTrailChromosome;
import alg.genProgAlgorithm.crossover.CrossoverInterface;
import alg.genProgAlgorithm.fitnessFunction.FitnessFunctionInterface;
import alg.genProgAlgorithm.initialization.InitializationInterface;
import alg.genProgAlgorithm.mutation.MutationInterface;
import alg.genProgAlgorithm.selection.SelectionInterface;

public class AntTrailGeneticAlgorithm extends AbstractGeneticAlgorithm<AntTrailChromosome> {
	private static Map originalMap;

	public AntTrailGeneticAlgorithm(Map map, InitializationInterface initializationStrategy, FitnessFunctionInterface func,
			SelectionInterface selectionStrategy, CrossoverInterface crossoverStrategy, MutationInterface mutationStrategy,
			int populationNum, boolean useElitism, double elitePercentage, int maxGenerationNum, int maxProgramHeight,
			double crossProb, double mutationProb) {
		super(func, initializationStrategy, selectionStrategy, crossoverStrategy, mutationStrategy, populationNum,
				useElitism, elitePercentage, maxGenerationNum, maxProgramHeight, crossProb, mutationProb);
		
		originalMap = map;
	}
	
	public String toString() {
		if(this.population == null || this.population.size() == 0) return "";
		String s = new String();
		
		s += "pos aptitude phenotype" + System.lineSeparator();
		for (int i = 0; i < this.population.size(); i++) {
			AntTrailChromosome elem = this.population.get(i);
			s += i + " " +
				 String.format("%5f", elem.getAptitude()) + " " +
				 elem.getPhenotype() + System.lineSeparator();
		}
		
		return s;
	}
	
	public static Map getMap() {
		return originalMap.clone();
	}

}
