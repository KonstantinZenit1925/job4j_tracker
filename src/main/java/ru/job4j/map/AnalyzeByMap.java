package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int result = 0;
        int summaScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summaScore += subject.score();
                result++;
            }
        }
        return summaScore / (double) result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            resultList.add(new Label(pupil.name(), (double) sumScore / pupil.subjects().size()));
        }
        return resultList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        Map<String, Integer> resMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                resMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String str : resMap.keySet()) {
            resultList.add(new Label(str, resMap.get(str) / (double) pupils.size()));
        }
        return resultList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            resultList.add(new Label(pupil.name(), sumScore));
        }
        resultList.sort(Comparator.naturalOrder());
        return resultList.get(resultList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> tempList = new ArrayList<>();
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String str : tempMap.keySet()) {
            tempList.add(new Label(str, tempMap.get(str)));
        }
        tempList.sort(Comparator.naturalOrder());
        return tempList.get(tempList.size() - 1);
    }
}

