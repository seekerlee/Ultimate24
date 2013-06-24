package io.github.seekerlee.algo24;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午9:59
 */
public class Algo24 {
    private Set<FractionalIntTrackable> resultSet = new HashSet<FractionalIntTrackable>();
    public Set<FractionalIntTrackable> doAlgo(List<FractionalIntTrackable> input, FractionalInt target) {
        // 0. return right answer if input size is 1
        if (input.size() == 1) {
        }
        // 1. make pair

        return null;
    }

    private class PairedSet<T> {
        private T pairL;
        private T pairR;
        private Set<T> remainSet;
    }
}
