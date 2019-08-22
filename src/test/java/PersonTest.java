import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test(expected = IllegalArgumentException.class)
    public void orderFilterNullIdsTest() {
        Person.order(new ArrayList<>(0),null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void orderFilterNullListTest() {
        Person.order(null, new int[]{1,2,3,4,5});
    }

    @Test
    public void orderFiltersPersonListTest(){
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(13, "Рёрик  "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        ));

        ArrayList<Person> expected = new ArrayList<>(Arrays.asList(
                new Person(1, "Аркадий"),
                new Person(13, "Рёрик  "),
                new Person(14, "Агафий "),
                new Person(15, "Мерилл "),
                new Person(8, "Серафим"),
                new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(9, "Агниил "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий")
        ));
        Person.order(list, new int[]{1,13,14,15,8});
        Assert.assertEquals(list,expected);

    }

    @Test
    public void orderFiltersPersonAndIgnoresEmptyIdListTest(){
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(13, "Рёрик  "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        ));

        ArrayList<Person> expected = new ArrayList<>(Arrays.asList(
                new Person(50, "Святополк"),
                new Person(13, "Рёрик  "),
                new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        ));
        Person.order(list, new int[]{50,122,13,17,19,20});
        Assert.assertEquals(list,expected);

    }

    @Test
    public void orderDontChangeListIfNotCanFindAnyExistIdTest(){
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(13, "Рёрик  "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        ));
        ArrayList<Person> expected = new ArrayList<>(Arrays.asList(new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(13, "Рёрик  "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        ));
        Person.order(list, new int[]{500,122,131,127,19,20});
        Assert.assertEquals(list,expected);

    }

}
