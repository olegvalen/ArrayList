import org.junit.Test;

import java.util.Arrays;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    @Test
    public void add() throws Exception {
        Integer[] expected = new Integer[]{null, null, 11, null};

        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(null);
        al.add(null);
        al.add(11);
        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void addStging() throws Exception {
        String[] expected = new String[]{null, null, "123", null};

        ArrayList<String> al = new ArrayList<>(2);
        al.add(null);
        al.add(null);
        al.add("123");
        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void addAll() throws Exception {
        Integer[] expected = new Integer[]{11, 12, 13, 14};
        Integer[] tmp = new Integer[]{13, 14};

        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);
        al.addAll(tmp);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void clear() throws Exception {
        Integer[] expected = new Integer[]{null, null};

        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);
        al.clear();

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void contain() throws Exception {
        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);

        assertTrue(al.contain(11));
    }

    @Test
    public void get() throws Exception {
        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);

        assertEquals(Integer.valueOf(12), al.get(1));
    }

    @Test
    public void indexOf() throws Exception {
        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);

        assertEquals(1, al.indexOf(Integer.valueOf(12)));
    }

    @Test
    public void isEmptyTrue() throws Exception {
        ArrayList<Integer> al = new ArrayList<>(2);

        assertEquals(true, al.isEmpty());
    }

    @Test
    public void isEmptyFalse() throws Exception {
        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);

        assertEquals(false, al.isEmpty());
    }

    @Test
    public void removeIndexStart() throws Exception {
        Integer[] expected = new Integer[]{12, 13};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(0);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeIndexMiddle() throws Exception {
        Integer[] expected = new Integer[]{11, 13};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(1);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeIndexEnd() throws Exception {
        Integer[] expected = new Integer[]{11, 12};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(2);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeItemStart() throws Exception {
        Integer[] expected = new Integer[]{12, 13};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(Integer.valueOf(11));

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeItemMiddle() throws Exception {
        Integer[] expected = new Integer[]{11, 13};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(Integer.valueOf(12));

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeItemEnd() throws Exception {
        Integer[] expected = new Integer[]{11, 12};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(11);
        al.add(12);
        al.add(13);
        al.remove(Integer.valueOf(13));

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void removeAll() throws Exception {
        Integer[] expected = new Integer[]{11, 13};

        ArrayList<Integer> al = new ArrayList<>(4);
        al.add(11);
        al.add(12);
        al.add(13);
        al.add(14);

        ArrayList<Integer> al2 = new ArrayList<>(2);
        al2.add(12);
        al2.add(14);

        al.removeAll(al2);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void retainAll() throws Exception {
        Integer[] expected = new Integer[]{11, 13};

        ArrayList<Integer> al = new ArrayList<>(4);
        al.add(11);
        al.add(12);
        al.add(13);
        al.add(14);

        ArrayList<Integer> al2 = new ArrayList<>(2);
        al2.add(11);
        al2.add(13);

        al.retainAll(al2);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void set() throws Exception {
        Integer[] expected = new Integer[]{11, 13};

        ArrayList<Integer> al = new ArrayList<>(2);
        al.add(11);
        al.add(12);

        al.set(1, 13);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void subList() throws Exception {
        Integer[] expected = new Integer[]{12, 13};

        ArrayList<Integer> al = new ArrayList<>(4);
        al.add(11);
        al.add(12);
        al.add(13);
        al.add(14);

        al.subList(1, 2);

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void reverse() throws Exception {
        Integer[] expected = new Integer[]{11, 12, 13};

        ArrayList<Integer> al = new ArrayList<>(3);
        al.add(13);
        al.add(12);
        al.add(11);

        al.reverse();

        assertEquals(Arrays.toString(expected), Arrays.toString(al.getAr()));
    }

    @Test
    public void cloneTest() throws Exception {
        Integer[] expected = new Integer[]{11, 12, 13};
        ArrayList<Integer> al = new ArrayList<>(3);
        al.setAr(expected);

        ArrayList<Integer> al2 = al.clone();

        assertEquals(Arrays.toString(al.getAr()), Arrays.toString(al2.getAr()));
    }

}