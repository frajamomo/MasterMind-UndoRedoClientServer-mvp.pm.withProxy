package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attemps;

    Memento(List<ProposedCombination> proposedCombinations, List<Result> results, int attemps ){

        cloneProposedCombinations(proposedCombinations);

        cloneResults(results);

        this.attemps = attemps;
    }

    private void cloneProposedCombinations(List<ProposedCombination> proposedCombinations) {
        this.proposedCombinations = new ArrayList<>();
        Iterator<ProposedCombination> it = proposedCombinations.iterator();
        while (it.hasNext()) {
            String proposedCombination = it.next().toString();
            ProposedCombination newProposedCombination = new ProposedCombination(proposedCombination);
            this.proposedCombinations.add(newProposedCombination);
        }
    }

    private void cloneResults(List<Result> results) {
        this.results = new ArrayList<>();
        Iterator<Result> it = results.iterator();
        while (it.hasNext()) {
            Result result = it.next();
            Result newResult = new Result(result.getBlacks(), result.getWhites());
            this.results.add(newResult);
        }
    }

    List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }

    List<Result> getResults(){
        return this.results;
    }

    int getAttempts(){
        return this.attemps;
    }
}