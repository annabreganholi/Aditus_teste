package com.aditusbr.test.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SortTest {

	private Sort sort = new Sort();

	@Test
	public void testEmptyArray() {
		int[] array = new int[0];

		sort.sort(array);

		assertEquals(0, array.length);
	}

	@Test
	public void testSingleArray() {
		int[] array = new int[1];
		array[0] = 20;

		sort.sort(array);

		assertEquals(1, array.length);
		assertEquals(20, array[0]);
	}

	@Test
	public void testDoubleArray() {
		int[] array = new int[2];
		array[0] = 20;
		array[1] = 9;

		sort.sort(array);

		assertEquals(2, array.length);
		assertEquals(9, array[0]);
		assertEquals(20, array[1]);
	}

	@Test
	public void testTripleArray() {
		int[] array = new int[3];
		array[0] = 12;
		array[1] = 20;
		array[2] = 9;

		sort.sort(array);

		assertEquals(3, array.length);
		assertEquals(9, array[0]);
		assertEquals(12, array[1]);
		assertEquals(20, array[2]);
	}

	@Test
	public void testBigArray() {
		int[] array = new int[100];
		array[0] = 94;
		array[1] = 56;
		array[2] = 50;
		array[3] = 97;
		array[4] = 41;
		array[5] = 27;
		array[6] = 24;
		array[7] = 67;
		array[8] = 69;
		array[9] = 83;
		array[10] = 76;
		array[11] = 67;
		array[12] = 64;
		array[13] = 94;
		array[14] = 84;
		array[15] = 46;
		array[16] = 2;
		array[17] = 86;
		array[18] = 89;
		array[19] = 82;
		array[20] = 16;
		array[21] = 82;
		array[22] = 37;
		array[23] = 63;
		array[24] = 32;
		array[25] = 62;
		array[26] = 70;
		array[27] = 70;
		array[28] = 35;
		array[29] = 12;
		array[30] = 6;
		array[31] = 66;
		array[32] = 82;
		array[33] = 67;
		array[34] = 94;
		array[35] = 2;
		array[36] = 42;
		array[37] = 26;
		array[38] = 88;
		array[39] = 94;
		array[40] = 83;
		array[41] = 39;
		array[42] = 93;
		array[43] = 22;
		array[44] = 12;
		array[45] = 70;
		array[46] = 99;
		array[47] = 69;
		array[48] = 81;
		array[49] = 96;
		array[50] = 28;
		array[51] = 60;
		array[52] = 37;
		array[53] = 65;
		array[54] = 12;
		array[55] = 37;
		array[56] = 27;
		array[57] = 93;
		array[58] = 25;
		array[59] = 43;
		array[60] = 73;
		array[61] = 20;
		array[62] = 82;
		array[63] = 84;
		array[64] = 89;
		array[65] = 38;
		array[66] = 53;
		array[67] = 51;
		array[68] = 28;
		array[69] = 22;
		array[70] = 46;
		array[71] = 45;
		array[72] = 9;
		array[73] = 91;
		array[74] = 78;
		array[75] = 46;
		array[76] = 66;
		array[77] = 12;
		array[78] = 73;
		array[79] = 52;
		array[80] = 97;
		array[81] = 80;
		array[82] = 76;
		array[83] = 27;
		array[84] = 62;
		array[85] = 46;
		array[86] = 54;
		array[87] = 94;
		array[88] = 25;
		array[89] = 52;
		array[90] = 34;
		array[91] = 87;
		array[92] = 16;
		array[93] = 4;
		array[94] = 2;
		array[95] = 34;
		array[96] = 52;
		array[97] = 21;
		array[98] = 35;
		array[99] = 6;

		sort.sort(array);

		assertEquals(2, array[0]);
		assertEquals(2, array[1]);
		assertEquals(2, array[2]);
		assertEquals(4, array[3]);
		assertEquals(6, array[4]);
		assertEquals(6, array[5]);
		assertEquals(9, array[6]);
		assertEquals(12, array[7]);
		assertEquals(12, array[8]);
		assertEquals(12, array[9]);
		assertEquals(12, array[10]);
		assertEquals(16, array[11]);
		assertEquals(16, array[12]);
		assertEquals(20, array[13]);
		assertEquals(21, array[14]);
		assertEquals(22, array[15]);
		assertEquals(22, array[16]);
		assertEquals(24, array[17]);
		assertEquals(25, array[18]);
		assertEquals(25, array[19]);
		assertEquals(26, array[20]);
		assertEquals(27, array[21]);
		assertEquals(27, array[22]);
		assertEquals(27, array[23]);
		assertEquals(28, array[24]);
		assertEquals(28, array[25]);
		assertEquals(32, array[26]);
		assertEquals(34, array[27]);
		assertEquals(34, array[28]);
		assertEquals(35, array[29]);
		assertEquals(35, array[30]);
		assertEquals(37, array[31]);
		assertEquals(37, array[32]);
		assertEquals(37, array[33]);
		assertEquals(38, array[34]);
		assertEquals(39, array[35]);
		assertEquals(41, array[36]);
		assertEquals(42, array[37]);
		assertEquals(43, array[38]);
		assertEquals(45, array[39]);
		assertEquals(46, array[40]);
		assertEquals(46, array[41]);
		assertEquals(46, array[42]);
		assertEquals(46, array[43]);
		assertEquals(50, array[44]);
		assertEquals(51, array[45]);
		assertEquals(52, array[46]);
		assertEquals(52, array[47]);
		assertEquals(52, array[48]);
		assertEquals(53, array[49]);
		assertEquals(54, array[50]);
		assertEquals(56, array[51]);
		assertEquals(60, array[52]);
		assertEquals(62, array[53]);
		assertEquals(62, array[54]);
		assertEquals(63, array[55]);
		assertEquals(64, array[56]);
		assertEquals(65, array[57]);
		assertEquals(66, array[58]);
		assertEquals(66, array[59]);
		assertEquals(67, array[60]);
		assertEquals(67, array[61]);
		assertEquals(67, array[62]);
		assertEquals(69, array[63]);
		assertEquals(69, array[64]);
		assertEquals(70, array[65]);
		assertEquals(70, array[66]);
		assertEquals(70, array[67]);
		assertEquals(73, array[68]);
		assertEquals(73, array[69]);
		assertEquals(76, array[70]);
		assertEquals(76, array[71]);
		assertEquals(78, array[72]);
		assertEquals(80, array[73]);
		assertEquals(81, array[74]);
		assertEquals(82, array[75]);
		assertEquals(82, array[76]);
		assertEquals(82, array[77]);
		assertEquals(82, array[78]);
		assertEquals(83, array[79]);
		assertEquals(83, array[80]);
		assertEquals(84, array[81]);
		assertEquals(84, array[82]);
		assertEquals(86, array[83]);
		assertEquals(87, array[84]);
		assertEquals(88, array[85]);
		assertEquals(89, array[86]);
		assertEquals(89, array[87]);
		assertEquals(91, array[88]);
		assertEquals(93, array[89]);
		assertEquals(93, array[90]);
		assertEquals(94, array[91]);
		assertEquals(94, array[92]);
		assertEquals(94, array[93]);
		assertEquals(94, array[94]);
		assertEquals(94, array[95]);
		assertEquals(96, array[96]);
		assertEquals(97, array[97]);
		assertEquals(97, array[98]);
		assertEquals(99, array[99]);
	}
}
