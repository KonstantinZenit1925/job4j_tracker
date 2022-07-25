package ru.job4j.map;
/**
 * Класс AnalyzeByMap получает статистику по аттестатам.
 */

import java.util.*;

public class AnalyzeByMap {
    /**
     * Метод averageScore() - вычисляет общий средний балл.
     * Пробегаем циклом по нашим оценкам, суммируем их, затем сумму оценок делим
     * Т.к возвращаемое значение double поэтому пришлось приводить int
     *
     * @param pupils
     * @return
     */
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

    /**
     * Метод averageScoreByPupil() - вычисляет средний балл по каждому ученику.
     * То есть берем одного ученика и считаем все его баллы за все предметы
     * и делим на количество предметов.
     * Возвращает список из объекта Label (имя ученика и средний балл).
     *
     * @param pupils
     * @return
     */
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

    /**
     * Метод averageScoreBySubject() - вычисляет средний балл по каждому предмету.
     * Например, собираем все баллы учеников по предмету география и делим на количество учеников.
     * Возвращает список из объектов Label (название предмета и средний балл).
     * https://www.programiz.com/java-programming/library/hashmap/merge
     *
     * @param pupils
     * @return
     */
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

    /**
     * Метод bestStudent() - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     * Возвращает объект Label (имя ученика и суммарный балл).
     *
     * @param pupils
     * @return
     */
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

    /**
     * Метод bestSubject() - возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Label (имя предмета, сумма баллов каждого ученика по этому предмету).
     *
     * @param pupils
     * @return
     */
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

