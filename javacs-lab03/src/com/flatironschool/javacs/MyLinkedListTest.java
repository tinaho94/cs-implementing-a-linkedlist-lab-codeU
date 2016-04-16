/**
 * 
 */
package com.flatironschool.javacs;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class MyLinkedListTest {

	private List<Integer> mll;
	private List<Integer> list;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		mll = new MyLinkedList<Integer>();
		mll.addAll(list);
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyArrayList() {
		assertThat(mll.size(), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		for (int i = 4; i < 20; i++) {
			mll.add(i);
		}
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mll.get(18), is(new Integer(19)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntT() {
		mll.add(1, 5);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mll.get(1), is(new Integer(5)));
		assertThat(mll.size(), is(4));
		
		try {
		    mll.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mll.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
		
		mll.add(0, 6);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mll.get(0), is(6));

		mll.add(5, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mll.get(5), is(new Integer(7)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsT() {
		mll.addAll(list);
		mll.addAll(list);
		mll.addAll(list);
		assertThat(mll.size(), is(12));
		assertThat(mll.get(5), is(new Integer(3)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		mll.clear();
		assertThat(mll.size(), is(0));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertThat(mll.contains(1), equalTo(true));
		System.out.println(Arrays.toString(mll.toArray()));
		assertThat(mll.contains(4), equalTo(false));
		assertThat(mll.contains(null), equalTo(false));
		mll.add(null);
		assertThat(mll.contains(null), equalTo(true));
		System.out.println(Arrays.toString(mll.toArray()));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#containsAll(java.util.Collection)}.
	 */
	@Test
	public void testContainsAll() {
		assertThat(mll.containsAll(list), equalTo(true));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		assertThat(mll.get(1), is(new Integer(2)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertThat(mll.indexOf(1), is(0));
		assertThat(mll.indexOf(2), is(1));
		assertThat(mll.indexOf(3), is(2));
		assertThat(mll.indexOf(4), is(-1));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOfNull() {
		assertThat(mll.indexOf(null), is(-1));
		mll.add(null);
		System.out.println(Arrays.toString(mll.toArray()));
		assertThat(mll.indexOf(null), is(3));		
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertThat(mll.isEmpty(), equalTo(false));
		mll.clear();
		assertThat(mll.isEmpty(), equalTo(true));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> iter = mll.iterator();
		assertThat(iter.next(), is(new Integer(1)));
		assertThat(iter.next(), is(new Integer(2)));
		assertThat(iter.next(), is(new Integer(3)));
		assertThat(iter.hasNext(), equalTo(false));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#lastIndexOf(java.lang.Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		mll.add(2);
		assertThat(mll.lastIndexOf(new Integer(2)), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		boolean flag = mll.remove(new Integer(2));
		assertThat(flag, equalTo(true));
		assertThat(mll.size(), is(2));
		assertThat(mll.get(1), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mll.remove(new Integer(1));
		assertThat(flag, equalTo(true));
		assertThat(mll.size(), is(1));
		assertThat(mll.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mll.toArray()));
		
		flag = mll.remove(new Integer(5));
		assertThat(flag, equalTo(false));
		assertThat(mll.size(), is(1));
		assertThat(mll.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mll.remove(new Integer(3));
		assertThat(flag, equalTo(true));
		assertThat(mll.size(), is(0));
		//System.out.println(Arrays.toString(mal.toArray()));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		System.out.println(Arrays.toString(mll.toArray()));
		Integer val = mll.remove(1);
		assertThat(val, is(new Integer(2)));
		assertThat(mll.size(), is(2));
		assertThat(mll.get(1), is(new Integer(3)));
		
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		mll.removeAll(list);
		assertThat(mll.size(), is(0));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		Integer val = mll.set(1, 5);
		assertThat(val, is(new Integer(2)));

		val = mll.set(0, 6);
		assertThat(val, is(new Integer(1)));

		val = mll.set(2, 7);
		assertThat(val, is(new Integer(3)));

		// return value should be 2
		// list should be [6, 5, 7]
		assertThat(mll.get(0), is(new Integer(6)));
		assertThat(mll.get(1), is(new Integer(5)));
		assertThat(mll.get(2), is(new Integer(7)));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mll.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mll.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		assertThat(mll.size(), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		mll.addAll(list);
		List<Integer> sub = mll.subList(1, 4);
		assertThat(sub.get(1), is(new Integer(3)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] array = mll.toArray();
		assertThat((Integer)array[0], is(new Integer(1)));
	}

}
