package io.github.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.util.SparseIntArray;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final SparseIntArray a = new SparseIntArray(1029);
  private static final SparseIntArray b = new SparseIntArray(471);
  private static final SparseIntArray c = new SparseIntArray(5);
  private static Map<String, Integer> d = new HashMap();
  
  static
  {
    c.put(127995, 1);
    c.put(127996, 1);
    c.put(127997, 1);
    c.put(127998, 1);
    c.put(127999, 1);
    a.put(128516, c.a.emoji_1f604);
    a.put(128515, c.a.emoji_1f603);
    a.put(128522, c.a.emoji_1f60a);
    a.put(9786, c.a.emoji_263a);
    a.put(128521, c.a.emoji_1f609);
    a.put(128525, c.a.emoji_1f60d);
    a.put(128536, c.a.emoji_1f618);
    a.put(128538, c.a.emoji_1f61a);
    a.put(128537, c.a.emoji_1f619);
    a.put(128540, c.a.emoji_1f61c);
    a.put(128541, c.a.emoji_1f61d);
    a.put(128539, c.a.emoji_1f61b);
    a.put(128563, c.a.emoji_1f633);
    a.put(128513, c.a.emoji_1f601);
    a.put(128532, c.a.emoji_1f614);
    a.put(128524, c.a.emoji_1f60c);
    a.put(128530, c.a.emoji_1f612);
    a.put(128542, c.a.emoji_1f61e);
    a.put(128547, c.a.emoji_1f623);
    a.put(128546, c.a.emoji_1f622);
    a.put(128514, c.a.emoji_1f602);
    a.put(128557, c.a.emoji_1f62d);
    a.put(128554, c.a.emoji_1f62a);
    a.put(128549, c.a.emoji_1f625);
    a.put(128560, c.a.emoji_1f630);
    a.put(128531, c.a.emoji_1f613);
    a.put(128552, c.a.emoji_1f628);
    a.put(128561, c.a.emoji_1f631);
    a.put(128544, c.a.emoji_1f620);
    a.put(128545, c.a.emoji_1f621);
    a.put(128548, c.a.emoji_1f624);
    a.put(128534, c.a.emoji_1f616);
    a.put(128523, c.a.emoji_1f60b);
    a.put(128567, c.a.emoji_1f637);
    a.put(128526, c.a.emoji_1f60e);
    a.put(128564, c.a.emoji_1f634);
    a.put(128562, c.a.emoji_1f632);
    a.put(128127, c.a.emoji_1f47f);
    a.put(128519, c.a.emoji_1f607);
    a.put(128114, c.a.emoji_1f472);
    a.put(128110, c.a.emoji_1f46e);
    a.put(128119, c.a.emoji_1f477);
    a.put(128130, c.a.emoji_1f482);
    a.put(128118, c.a.emoji_1f476);
    a.put(128102, c.a.emoji_1f466);
    a.put(128103, c.a.emoji_1f467);
    a.put(128104, c.a.emoji_1f468);
    a.put(128105, c.a.emoji_1f469);
    a.put(128116, c.a.emoji_1f474);
    a.put(128117, c.a.emoji_1f475);
    a.put(128113, c.a.emoji_1f471);
    a.put(128124, c.a.emoji_1f47c);
    a.put(128120, c.a.emoji_1f478);
    a.put(128128, c.a.emoji_1f480);
    a.put(128125, c.a.emoji_1f47d);
    a.put(128169, c.a.emoji_1f4a9);
    a.put(128293, c.a.emoji_1f525);
    a.put(10024, c.a.emoji_2728);
    a.put(128162, c.a.emoji_1f4a2);
    a.put(128166, c.a.emoji_1f4a6);
    a.put(128164, c.a.emoji_1f4a4);
    a.put(128168, c.a.emoji_1f4a8);
    a.put(128066, c.a.emoji_1f442);
    a.put(128064, c.a.emoji_1f440);
    a.put(128067, c.a.emoji_1f443);
    a.put(128068, c.a.emoji_1f444);
    a.put(128077, c.a.emoji_1f44d);
    a.put(128078, c.a.emoji_1f44e);
    a.put(128076, c.a.emoji_1f44c);
    a.put(128074, c.a.emoji_1f44a);
    a.put(9994, c.a.emoji_270a);
    a.put(9996, c.a.emoji_270c);
    a.put(128075, c.a.emoji_1f44b);
    a.put(9995, c.a.emoji_270b);
    a.put(128080, c.a.emoji_1f450);
    a.put(128070, c.a.emoji_1f446);
    a.put(128071, c.a.emoji_1f447);
    a.put(128073, c.a.emoji_1f449);
    a.put(128072, c.a.emoji_1f448);
    a.put(128588, c.a.emoji_1f64c);
    a.put(128591, c.a.emoji_1f64f);
    a.put(9757, c.a.emoji_261d);
    a.put(128079, c.a.emoji_1f44f);
    a.put(128170, c.a.emoji_1f4aa);
    a.put(128694, c.a.emoji_1f6b6);
    a.put(127939, c.a.emoji_1f3c3);
    a.put(128131, c.a.emoji_1f483);
    a.put(128107, c.a.emoji_1f46b);
    a.put(128143, c.a.emoji_1f48f);
    a.put(128145, c.a.emoji_1f491);
    a.put(128111, c.a.emoji_1f46f);
    a.put(128582, c.a.emoji_1f646);
    a.put(128581, c.a.emoji_1f645);
    a.put(128129, c.a.emoji_1f481);
    a.put(128134, c.a.emoji_1f486);
    a.put(128135, c.a.emoji_1f487);
    a.put(128133, c.a.emoji_1f485);
    a.put(128583, c.a.emoji_1f647);
    a.put(127913, c.a.emoji_1f3a9);
    a.put(128082, c.a.emoji_1f452);
    a.put(128094, c.a.emoji_1f45e);
    a.put(128097, c.a.emoji_1f461);
    a.put(128096, c.a.emoji_1f460);
    a.put(128098, c.a.emoji_1f462);
    a.put(128085, c.a.emoji_1f455);
    a.put(128084, c.a.emoji_1f454);
    a.put(128087, c.a.emoji_1f457);
    a.put(128088, c.a.emoji_1f458);
    a.put(128089, c.a.emoji_1f459);
    a.put(128188, c.a.emoji_1f4bc);
    a.put(128092, c.a.emoji_1f45c);
    a.put(128083, c.a.emoji_1f453);
    a.put(127872, c.a.emoji_1f380);
    a.put(127746, c.a.emoji_1f302);
    a.put(128132, c.a.emoji_1f484);
    a.put(128155, c.a.emoji_1f49b);
    a.put(128153, c.a.emoji_1f499);
    a.put(128156, c.a.emoji_1f49c);
    a.put(128154, c.a.emoji_1f49a);
    a.put(10084, c.a.emoji_2764);
    a.put(128148, c.a.emoji_1f494);
    a.put(128150, c.a.emoji_1f496);
    a.put(128158, c.a.emoji_1f49e);
    a.put(128152, c.a.emoji_1f498);
    a.put(128140, c.a.emoji_1f48c);
    a.put(128139, c.a.emoji_1f48b);
    a.put(128141, c.a.emoji_1f48d);
    a.put(128142, c.a.emoji_1f48e);
    a.put(128099, c.a.emoji_1f463);
    a.put(128054, c.a.emoji_1f436);
    a.put(128058, c.a.emoji_1f43a);
    a.put(128049, c.a.emoji_1f431);
    a.put(128045, c.a.emoji_1f42d);
    a.put(128057, c.a.emoji_1f439);
    a.put(128048, c.a.emoji_1f430);
    a.put(128056, c.a.emoji_1f438);
    a.put(128047, c.a.emoji_1f42f);
    a.put(128040, c.a.emoji_1f428);
    a.put(128059, c.a.emoji_1f43b);
    a.put(128055, c.a.emoji_1f437);
    a.put(128046, c.a.emoji_1f42e);
    a.put(128023, c.a.emoji_1f417);
    a.put(128053, c.a.emoji_1f435);
    a.put(128018, c.a.emoji_1f412);
    a.put(128052, c.a.emoji_1f434);
    a.put(128017, c.a.emoji_1f411);
    a.put(128024, c.a.emoji_1f418);
    a.put(128039, c.a.emoji_1f427);
    a.put(128038, c.a.emoji_1f426);
    a.put(128036, c.a.emoji_1f424);
    a.put(128037, c.a.emoji_1f425);
    a.put(128020, c.a.emoji_1f414);
    a.put(128013, c.a.emoji_1f40d);
    a.put(128027, c.a.emoji_1f41b);
    a.put(128025, c.a.emoji_1f419);
    a.put(128026, c.a.emoji_1f41a);
    a.put(128032, c.a.emoji_1f420);
    a.put(128031, c.a.emoji_1f41f);
    a.put(128044, c.a.emoji_1f42c);
    a.put(128051, c.a.emoji_1f433);
    a.put(128014, c.a.emoji_1f40e);
    a.put(128043, c.a.emoji_1f42b);
    a.put(128144, c.a.emoji_1f490);
    a.put(127800, c.a.emoji_1f338);
    a.put(127799, c.a.emoji_1f337);
    a.put(127808, c.a.emoji_1f340);
    a.put(127801, c.a.emoji_1f339);
    a.put(127803, c.a.emoji_1f33b);
    a.put(127802, c.a.emoji_1f33a);
    a.put(127809, c.a.emoji_1f341);
    a.put(127811, c.a.emoji_1f343);
    a.put(127810, c.a.emoji_1f342);
    a.put(127806, c.a.emoji_1f33e);
    a.put(127797, c.a.emoji_1f335);
    a.put(127796, c.a.emoji_1f334);
    a.put(127769, c.a.emoji_1f319);
    a.put(127776, c.a.emoji_1f303);
    a.put(11088, c.a.emoji_2b50);
    a.put(9728, c.a.emoji_2600);
    a.put(9729, c.a.emoji_2601);
    a.put(9889, c.a.emoji_26a1);
    a.put(9748, c.a.emoji_2614);
    a.put(9924, c.a.emoji_26c4);
    a.put(127744, c.a.emoji_1f300);
    a.put(127752, c.a.emoji_1f308);
    a.put(127754, c.a.emoji_1f30a);
    a.put(127885, c.a.emoji_1f38d);
    a.put(128157, c.a.emoji_1f49d);
    a.put(127886, c.a.emoji_1f38e);
    a.put(127890, c.a.emoji_1f392);
    a.put(127887, c.a.emoji_1f38f);
    a.put(127878, c.a.emoji_1f386);
    a.put(127879, c.a.emoji_1f387);
    a.put(127888, c.a.emoji_1f390);
    a.put(127889, c.a.emoji_1f391);
    a.put(127875, c.a.emoji_1f383);
    a.put(128123, c.a.emoji_1f47b);
    a.put(127877, c.a.emoji_1f385);
    a.put(127876, c.a.emoji_1f384);
    a.put(127873, c.a.emoji_1f381);
    a.put(127881, c.a.emoji_1f389);
    a.put(127880, c.a.emoji_1f388);
    a.put(127884, c.a.emoji_1f38c);
    a.put(127909, c.a.emoji_1f3a5);
    a.put(128247, c.a.emoji_1f4f7);
    a.put(128252, c.a.emoji_1f4fc);
    a.put(128191, c.a.emoji_1f4bf);
    a.put(128192, c.a.emoji_1f4c0);
    a.put(128189, c.a.emoji_1f4bd);
    a.put(128187, c.a.emoji_1f4bb);
    a.put(128241, c.a.emoji_1f4f1);
    a.put(9742, c.a.emoji_260e);
    a.put(128224, c.a.emoji_1f4e0);
    a.put(128225, c.a.emoji_1f4e1);
    a.put(128250, c.a.emoji_1f4fa);
    a.put(128251, c.a.emoji_1f4fb);
    a.put(128265, c.a.emoji_1f509);
    a.put(128276, c.a.emoji_1f514);
    a.put(128226, c.a.emoji_1f4e2);
    a.put(128227, c.a.emoji_1f4e3);
    a.put(9203, c.a.emoji_23f3);
    a.put(9200, c.a.emoji_23f0);
    a.put(128275, c.a.emoji_1f513);
    a.put(128274, c.a.emoji_1f512);
    a.put(128273, c.a.emoji_1f511);
    a.put(128161, c.a.emoji_1f4a1);
    a.put(128269, c.a.emoji_1f50d);
    a.put(128704, c.a.emoji_1f6c0);
    a.put(128703, c.a.emoji_1f6bf);
    a.put(128701, c.a.emoji_1f6bd);
    a.put(128296, c.a.emoji_1f528);
    a.put(128684, c.a.emoji_1f6ac);
    a.put(128163, c.a.emoji_1f4a3);
    a.put(128299, c.a.emoji_1f52b);
    a.put(128138, c.a.emoji_1f48a);
    a.put(128137, c.a.emoji_1f489);
    a.put(128176, c.a.emoji_1f4b0);
    a.put(128179, c.a.emoji_1f4b3);
    a.put(128242, c.a.emoji_1f4f2);
    a.put(128233, c.a.emoji_1f4e9);
    a.put(128236, c.a.emoji_1f4ec);
    a.put(128238, c.a.emoji_1f4ee);
    a.put(128221, c.a.emoji_1f4dd);
    a.put(9986, c.a.emoji_2702);
    a.put(10002, c.a.emoji_2712);
    a.put(128214, c.a.emoji_1f4d6);
    a.put(128301, c.a.emoji_1f52d);
    a.put(127912, c.a.emoji_1f3a8);
    a.put(127916, c.a.emoji_1f3ac);
    a.put(127908, c.a.emoji_1f3a4);
    a.put(127911, c.a.emoji_1f3a7);
    a.put(127925, c.a.emoji_1f3b5);
    a.put(127926, c.a.emoji_1f3b6);
    a.put(127931, c.a.emoji_1f3bb);
    a.put(127930, c.a.emoji_1f3ba);
    a.put(127927, c.a.emoji_1f3b7);
    a.put(127928, c.a.emoji_1f3b8);
    a.put(128126, c.a.emoji_1f47e);
    a.put(126980, c.a.emoji_1f004);
    a.put(127919, c.a.emoji_1f3af);
    a.put(127944, c.a.emoji_1f3c8);
    a.put(127936, c.a.emoji_1f3c0);
    a.put(9917, c.a.emoji_26bd);
    a.put(9918, c.a.emoji_26be);
    a.put(127934, c.a.emoji_1f3be);
    a.put(127921, c.a.emoji_1f3b1);
    a.put(127937, c.a.emoji_1f3c1);
    a.put(127942, c.a.emoji_1f3c6);
    a.put(127935, c.a.emoji_1f3bf);
    a.put(127946, c.a.emoji_1f3ca);
    a.put(127940, c.a.emoji_1f3c4);
    a.put(9749, c.a.emoji_2615);
    a.put(127861, c.a.emoji_1f375);
    a.put(127862, c.a.emoji_1f376);
    a.put(127866, c.a.emoji_1f37a);
    a.put(127867, c.a.emoji_1f37b);
    a.put(127864, c.a.emoji_1f378);
    a.put(127860, c.a.emoji_1f374);
    a.put(127828, c.a.emoji_1f354);
    a.put(127839, c.a.emoji_1f35f);
    a.put(127830, c.a.emoji_1f356);
    a.put(127837, c.a.emoji_1f35d);
    a.put(127835, c.a.emoji_1f35b);
    a.put(127857, c.a.emoji_1f371);
    a.put(127843, c.a.emoji_1f363);
    a.put(127833, c.a.emoji_1f359);
    a.put(127832, c.a.emoji_1f358);
    a.put(127834, c.a.emoji_1f35a);
    a.put(127836, c.a.emoji_1f35c);
    a.put(127858, c.a.emoji_1f372);
    a.put(127842, c.a.emoji_1f362);
    a.put(127841, c.a.emoji_1f361);
    a.put(127838, c.a.emoji_1f35e);
    a.put(127846, c.a.emoji_1f366);
    a.put(127847, c.a.emoji_1f367);
    a.put(127874, c.a.emoji_1f382);
    a.put(127856, c.a.emoji_1f370);
    a.put(127853, c.a.emoji_1f36d);
    a.put(127822, c.a.emoji_1f34e);
    a.put(127818, c.a.emoji_1f34a);
    a.put(127817, c.a.emoji_1f349);
    a.put(127827, c.a.emoji_1f353);
    a.put(127825, c.a.emoji_1f351);
    a.put(127816, c.a.emoji_1f348);
    a.put(127814, c.a.emoji_1f346);
    a.put(127968, c.a.emoji_1f3e0);
    a.put(127979, c.a.emoji_1f3eb);
    a.put(127970, c.a.emoji_1f3e2);
    a.put(127971, c.a.emoji_1f3e3);
    a.put(127973, c.a.emoji_1f3e5);
    a.put(127974, c.a.emoji_1f3e6);
    a.put(127978, c.a.emoji_1f3ea);
    a.put(127977, c.a.emoji_1f3e9);
    a.put(127976, c.a.emoji_1f3e8);
    a.put(128146, c.a.emoji_1f492);
    a.put(9962, c.a.emoji_26ea);
    a.put(127980, c.a.emoji_1f3ec);
    a.put(127751, c.a.emoji_1f307);
    a.put(127750, c.a.emoji_1f306);
    a.put(127983, c.a.emoji_1f3ef);
    a.put(127984, c.a.emoji_1f3f0);
    a.put(9978, c.a.emoji_26fa);
    a.put(127981, c.a.emoji_1f3ed);
    a.put(128508, c.a.emoji_1f5fc);
    a.put(128507, c.a.emoji_1f5fb);
    a.put(127748, c.a.emoji_1f304);
    a.put(127749, c.a.emoji_1f305);
    a.put(127747, c.a.emoji_1f303);
    a.put(128509, c.a.emoji_1f5fd);
    a.put(127905, c.a.emoji_1f3a1);
    a.put(9970, c.a.emoji_26f2);
    a.put(127906, c.a.emoji_1f3a2);
    a.put(128674, c.a.emoji_1f6a2);
    a.put(9973, c.a.emoji_26f5);
    a.put(128676, c.a.emoji_1f6a4);
    a.put(9875, c.a.emoji_2693);
    a.put(128640, c.a.emoji_1f680);
    a.put(9992, c.a.emoji_2708);
    a.put(128186, c.a.emoji_1f4ba);
    a.put(128649, c.a.emoji_1f689);
    a.put(128646, c.a.emoji_1f686);
    a.put(128644, c.a.emoji_1f684);
    a.put(128647, c.a.emoji_1f687);
    a.put(128652, c.a.emoji_1f68c);
    a.put(128665, c.a.emoji_1f699);
    a.put(128663, c.a.emoji_1f697);
    a.put(128661, c.a.emoji_1f695);
    a.put(128666, c.a.emoji_1f69a);
    a.put(128659, c.a.emoji_1f693);
    a.put(128658, c.a.emoji_1f692);
    a.put(128657, c.a.emoji_1f691);
    a.put(128690, c.a.emoji_1f6b2);
    a.put(128136, c.a.emoji_1f488);
    a.put(128655, c.a.emoji_1f68f);
    a.put(127915, c.a.emoji_1f3ab);
    a.put(128677, c.a.emoji_1f6a5);
    a.put(9888, c.a.emoji_26a0);
    a.put(128679, c.a.emoji_1f6a7);
    a.put(128304, c.a.emoji_1f530);
    a.put(9981, c.a.emoji_26fd);
    a.put(9832, c.a.emoji_2668);
    a.put(11014, c.a.emoji_2b06);
    a.put(11015, c.a.emoji_2b07);
    a.put(11013, c.a.emoji_2b05);
    a.put(10145, c.a.emoji_27a1);
    a.put(8599, c.a.emoji_2197);
    a.put(8598, c.a.emoji_2196);
    a.put(8600, c.a.emoji_2198);
    a.put(8601, c.a.emoji_2199);
    a.put(9664, c.a.emoji_25c0);
    a.put(9654, c.a.emoji_25b6);
    a.put(9194, c.a.emoji_23ea);
    a.put(9193, c.a.emoji_23e9);
    a.put(127383, c.a.emoji_1f197);
    a.put(127381, c.a.emoji_1f195);
    a.put(127385, c.a.emoji_1f199);
    a.put(127378, c.a.emoji_1f192);
    a.put(128246, c.a.emoji_1f4f6);
    a.put(127910, c.a.emoji_1f3a6);
    a.put(127489, c.a.emoji_1f201);
    a.put(127535, c.a.emoji_1f22f);
    a.put(127539, c.a.emoji_1f233);
    a.put(127541, c.a.emoji_1f235);
    a.put(127568, c.a.emoji_1f250);
    a.put(127545, c.a.emoji_1f239);
    a.put(127546, c.a.emoji_1f23a);
    a.put(127542, c.a.emoji_1f236);
    a.put(127514, c.a.emoji_1f21a);
    a.put(128699, c.a.emoji_1f6bb);
    a.put(128697, c.a.emoji_1f6b9);
    a.put(128698, c.a.emoji_1f6ba);
    a.put(128700, c.a.emoji_1f6bc);
    a.put(128702, c.a.emoji_1f6be);
    a.put(127359, c.a.emoji_1f17f);
    a.put(9855, c.a.emoji_267f);
    a.put(128685, c.a.emoji_1f6ad);
    a.put(127543, c.a.emoji_1f237);
    a.put(127544, c.a.emoji_1f238);
    a.put(127490, c.a.emoji_1f202);
    a.put(12953, c.a.emoji_3299);
    a.put(12951, c.a.emoji_3297);
    a.put(127380, c.a.emoji_1f194);
    a.put(128286, c.a.emoji_1f51e);
    a.put(10035, c.a.emoji_2733);
    a.put(10036, c.a.emoji_2734);
    a.put(128159, c.a.emoji_1f49f);
    a.put(127386, c.a.emoji_1f19a);
    a.put(128243, c.a.emoji_1f4f3);
    a.put(128244, c.a.emoji_1f4f4);
    a.put(127344, c.a.emoji_1f170);
    a.put(127345, c.a.emoji_1f171);
    a.put(127374, c.a.emoji_1f18e);
    a.put(127358, c.a.emoji_1f17e);
    a.put(10175, c.a.emoji_27bf);
    a.put(9800, c.a.emoji_2648);
    a.put(9801, c.a.emoji_2649);
    a.put(9802, c.a.emoji_264a);
    a.put(9803, c.a.emoji_264b);
    a.put(9804, c.a.emoji_264c);
    a.put(9805, c.a.emoji_264d);
    a.put(9806, c.a.emoji_264e);
    a.put(9807, c.a.emoji_264f);
    a.put(9808, c.a.emoji_2650);
    a.put(9809, c.a.emoji_2651);
    a.put(9810, c.a.emoji_2652);
    a.put(9811, c.a.emoji_2653);
    a.put(9934, c.a.emoji_26ce);
    a.put(128303, c.a.emoji_1f52f);
    a.put(127975, c.a.emoji_1f3e7);
    a.put(128185, c.a.emoji_1f4b9);
    a.put(128177, c.a.emoji_1f4b1);
    a.put(8482, c.a.emoji_2122);
    a.put(10060, c.a.emoji_274c);
    a.put(10071, c.a.emoji_2757);
    a.put(10067, c.a.emoji_2753);
    a.put(11093, c.a.emoji_2b55);
    a.put(128285, c.a.emoji_1f51d);
    a.put(128347, c.a.emoji_1f55b);
    a.put(128336, c.a.emoji_1f550);
    a.put(128337, c.a.emoji_1f551);
    a.put(128338, c.a.emoji_1f552);
    a.put(128339, c.a.emoji_1f553);
    a.put(128340, c.a.emoji_1f554);
    a.put(128341, c.a.emoji_1f555);
    a.put(128342, c.a.emoji_1f556);
    a.put(128343, c.a.emoji_1f557);
    a.put(128344, c.a.emoji_1f558);
    a.put(128345, c.a.emoji_1f559);
    a.put(128346, c.a.emoji_1f55a);
    a.put(128356, c.a.emoji_1f564);
    a.put(9824, c.a.emoji_2660);
    a.put(9829, c.a.emoji_2665);
    a.put(9827, c.a.emoji_2663);
    a.put(9830, c.a.emoji_2666);
    a.put(12349, c.a.emoji_303d);
    a.put(128305, c.a.emoji_1f531);
    a.put(9899, c.a.emoji_26ab);
    a.put(128308, c.a.emoji_1f534);
    a.put(128309, c.a.emoji_1f535);
    b.put(57345, c.a.emoji_1f466);
    b.put(57346, c.a.emoji_1f467);
    b.put(57347, c.a.emoji_1f48b);
    b.put(57348, c.a.emoji_1f468);
    b.put(57349, c.a.emoji_1f469);
    b.put(57350, c.a.emoji_1f455);
    b.put(57351, c.a.emoji_1f45e);
    b.put(57352, c.a.emoji_1f4f7);
    b.put(57354, c.a.emoji_1f4f1);
    b.put(57355, c.a.emoji_1f4e0);
    b.put(57356, c.a.emoji_1f4bb);
    b.put(57357, c.a.emoji_1f44a);
    b.put(57358, c.a.emoji_1f44d);
    b.put(57359, c.a.emoji_261d);
    b.put(57360, c.a.emoji_270a);
    b.put(57361, c.a.emoji_270c);
    b.put(57363, c.a.emoji_1f3bf);
    b.put(57365, c.a.emoji_1f3be);
    b.put(57366, c.a.emoji_26be);
    b.put(57367, c.a.emoji_1f3c4);
    b.put(57368, c.a.emoji_26bd);
    b.put(57370, c.a.emoji_1f434);
    b.put(57371, c.a.emoji_1f697);
    b.put(57372, c.a.emoji_26f5);
    b.put(57373, c.a.emoji_2708);
    b.put(57376, c.a.emoji_2753);
    b.put(57377, c.a.emoji_2757);
    b.put(57378, c.a.emoji_2764);
    b.put(57379, c.a.emoji_1f494);
    b.put(57380, c.a.emoji_1f550);
    b.put(57381, c.a.emoji_1f551);
    b.put(57382, c.a.emoji_1f552);
    b.put(57383, c.a.emoji_1f553);
    b.put(57384, c.a.emoji_1f554);
    b.put(57385, c.a.emoji_1f555);
    b.put(57386, c.a.emoji_1f556);
    b.put(57387, c.a.emoji_1f557);
    b.put(57388, c.a.emoji_1f558);
    b.put(57389, c.a.emoji_1f559);
    b.put(57390, c.a.emoji_1f55a);
    b.put(57391, c.a.emoji_1f55b);
    b.put(57392, c.a.emoji_1f338);
    b.put(57393, c.a.emoji_1f531);
    b.put(57394, c.a.emoji_1f339);
    b.put(57395, c.a.emoji_1f384);
    b.put(57396, c.a.emoji_1f48d);
    b.put(57397, c.a.emoji_1f48e);
    b.put(57398, c.a.emoji_1f3e0);
    b.put(57399, c.a.emoji_26ea);
    b.put(57400, c.a.emoji_1f3e2);
    b.put(57401, c.a.emoji_1f689);
    b.put(57402, c.a.emoji_26fd);
    b.put(57403, c.a.emoji_1f5fb);
    b.put(57404, c.a.emoji_1f3a4);
    b.put(57405, c.a.emoji_1f3a5);
    b.put(57406, c.a.emoji_1f3b5);
    b.put(57407, c.a.emoji_1f511);
    b.put(57408, c.a.emoji_1f3b7);
    b.put(57409, c.a.emoji_1f3b8);
    b.put(57410, c.a.emoji_1f3ba);
    b.put(57411, c.a.emoji_1f374);
    b.put(57413, c.a.emoji_2615);
    b.put(57414, c.a.emoji_1f370);
    b.put(57415, c.a.emoji_1f37a);
    b.put(57416, c.a.emoji_26c4);
    b.put(57417, c.a.emoji_2601);
    b.put(57418, c.a.emoji_2600);
    b.put(57419, c.a.emoji_2614);
    b.put(57421, c.a.emoji_1f304);
    b.put(57422, c.a.emoji_1f47c);
    b.put(57423, c.a.emoji_1f431);
    b.put(57424, c.a.emoji_1f42f);
    b.put(57425, c.a.emoji_1f43b);
    b.put(57427, c.a.emoji_1f42d);
    b.put(57428, c.a.emoji_1f433);
    b.put(57429, c.a.emoji_1f427);
    b.put(57430, c.a.emoji_1f60a);
    b.put(57431, c.a.emoji_1f603);
    b.put(57432, c.a.emoji_1f61e);
    b.put(57433, c.a.emoji_1f620);
    b.put(57434, c.a.emoji_1f4a9);
    b.put(57602, c.a.emoji_1f4ee);
    b.put(57604, c.a.emoji_1f4f2);
    b.put(57605, c.a.emoji_1f61c);
    b.put(57606, c.a.emoji_1f60d);
    b.put(57607, c.a.emoji_1f631);
    b.put(57608, c.a.emoji_1f613);
    b.put(57609, c.a.emoji_1f435);
    b.put(57610, c.a.emoji_1f419);
    b.put(57611, c.a.emoji_1f437);
    b.put(57612, c.a.emoji_1f47d);
    b.put(57613, c.a.emoji_1f680);
    b.put(57615, c.a.emoji_1f4a1);
    b.put(57617, c.a.emoji_1f48f);
    b.put(57618, c.a.emoji_1f381);
    b.put(57619, c.a.emoji_1f52b);
    b.put(57620, c.a.emoji_1f50d);
    b.put(57621, c.a.emoji_1f3c3);
    b.put(57622, c.a.emoji_1f528);
    b.put(57623, c.a.emoji_1f386);
    b.put(57624, c.a.emoji_1f341);
    b.put(57625, c.a.emoji_1f342);
    b.put(57626, c.a.emoji_1f47f);
    b.put(57627, c.a.emoji_1f47b);
    b.put(57628, c.a.emoji_1f480);
    b.put(57629, c.a.emoji_1f525);
    b.put(57630, c.a.emoji_1f4bc);
    b.put(57631, c.a.emoji_1f4ba);
    b.put(57632, c.a.emoji_1f354);
    b.put(57633, c.a.emoji_26f2);
    b.put(57634, c.a.emoji_26fa);
    b.put(57635, c.a.emoji_2668);
    b.put(57636, c.a.emoji_1f3a1);
    b.put(57637, c.a.emoji_1f3ab);
    b.put(57638, c.a.emoji_1f4bf);
    b.put(57639, c.a.emoji_1f4c0);
    b.put(57640, c.a.emoji_1f4fb);
    b.put(57641, c.a.emoji_1f4fc);
    b.put(57642, c.a.emoji_1f4fa);
    b.put(57643, c.a.emoji_1f47e);
    b.put(57644, c.a.emoji_303d);
    b.put(57645, c.a.emoji_1f004);
    b.put(57646, c.a.emoji_1f19a);
    b.put(57647, c.a.emoji_1f4b0);
    b.put(57648, c.a.emoji_1f3af);
    b.put(57649, c.a.emoji_1f3c6);
    b.put(57650, c.a.emoji_1f3c1);
    b.put(57652, c.a.emoji_1f40e);
    b.put(57653, c.a.emoji_1f6a4);
    b.put(57654, c.a.emoji_1f6b2);
    b.put(57655, c.a.emoji_1f6a7);
    b.put(57656, c.a.emoji_1f6b9);
    b.put(57657, c.a.emoji_1f6ba);
    b.put(57658, c.a.emoji_1f6bc);
    b.put(57659, c.a.emoji_1f489);
    b.put(57660, c.a.emoji_1f4a4);
    b.put(57661, c.a.emoji_26a1);
    b.put(57662, c.a.emoji_1f460);
    b.put(57663, c.a.emoji_1f6c0);
    b.put(57664, c.a.emoji_1f6bd);
    b.put(57666, c.a.emoji_1f4e2);
    b.put(57667, c.a.emoji_1f38c);
    b.put(57669, c.a.emoji_1f513);
    b.put(57670, c.a.emoji_1f306);
    b.put(57673, c.a.emoji_1f4b1);
    b.put(57674, c.a.emoji_1f4b9);
    b.put(57675, c.a.emoji_1f4e1);
    b.put(57676, c.a.emoji_1f4aa);
    b.put(57677, c.a.emoji_1f3e6);
    b.put(57678, c.a.emoji_1f6a5);
    b.put(57679, c.a.emoji_1f17f);
    b.put(57680, c.a.emoji_1f68f);
    b.put(57681, c.a.emoji_1f6bb);
    b.put(57682, c.a.emoji_1f46e);
    b.put(57683, c.a.emoji_1f3e3);
    b.put(57684, c.a.emoji_1f3e7);
    b.put(57685, c.a.emoji_1f3e5);
    b.put(57686, c.a.emoji_1f3ea);
    b.put(57687, c.a.emoji_1f3eb);
    b.put(57688, c.a.emoji_1f3e8);
    b.put(57689, c.a.emoji_1f68c);
    b.put(57690, c.a.emoji_1f695);
    b.put(57857, c.a.emoji_1f6b6);
    b.put(57858, c.a.emoji_1f6a2);
    b.put(57859, c.a.emoji_1f201);
    b.put(57860, c.a.emoji_1f49f);
    b.put(57861, c.a.emoji_2734);
    b.put(57862, c.a.emoji_2733);
    b.put(57863, c.a.emoji_1f51e);
    b.put(57864, c.a.emoji_1f6ad);
    b.put(57865, c.a.emoji_1f530);
    b.put(57866, c.a.emoji_267f);
    b.put(57867, c.a.emoji_1f4f6);
    b.put(57868, c.a.emoji_2665);
    b.put(57869, c.a.emoji_2666);
    b.put(57870, c.a.emoji_2660);
    b.put(57871, c.a.emoji_2663);
    b.put(57872, c.a.emoji_0023);
    b.put(57873, c.a.emoji_27bf);
    b.put(57874, c.a.emoji_1f195);
    b.put(57875, c.a.emoji_1f199);
    b.put(57876, c.a.emoji_1f192);
    b.put(57877, c.a.emoji_1f236);
    b.put(57878, c.a.emoji_1f21a);
    b.put(57879, c.a.emoji_1f237);
    b.put(57880, c.a.emoji_1f238);
    b.put(57881, c.a.emoji_1f534);
    b.put(57884, c.a.emoji_0031);
    b.put(57885, c.a.emoji_0032);
    b.put(57886, c.a.emoji_0033);
    b.put(57887, c.a.emoji_0034);
    b.put(57888, c.a.emoji_0035);
    b.put(57889, c.a.emoji_0036);
    b.put(57890, c.a.emoji_0037);
    b.put(57891, c.a.emoji_0038);
    b.put(57892, c.a.emoji_0039);
    b.put(57893, c.a.emoji_0030);
    b.put(57894, c.a.emoji_1f250);
    b.put(57895, c.a.emoji_1f239);
    b.put(57896, c.a.emoji_1f202);
    b.put(57897, c.a.emoji_1f194);
    b.put(57898, c.a.emoji_1f235);
    b.put(57899, c.a.emoji_1f233);
    b.put(57900, c.a.emoji_1f22f);
    b.put(57901, c.a.emoji_1f23a);
    b.put(57902, c.a.emoji_1f446);
    b.put(57903, c.a.emoji_1f447);
    b.put(57904, c.a.emoji_1f448);
    b.put(57905, c.a.emoji_1f449);
    b.put(57906, c.a.emoji_2b06);
    b.put(57907, c.a.emoji_2b07);
    b.put(57908, c.a.emoji_27a1);
    b.put(57910, c.a.emoji_2197);
    b.put(57911, c.a.emoji_2196);
    b.put(57912, c.a.emoji_2198);
    b.put(57913, c.a.emoji_2199);
    b.put(57914, c.a.emoji_25b6);
    b.put(57915, c.a.emoji_25c0);
    b.put(57916, c.a.emoji_23e9);
    b.put(57917, c.a.emoji_23ea);
    b.put(57919, c.a.emoji_2648);
    b.put(57920, c.a.emoji_2649);
    b.put(57921, c.a.emoji_264a);
    b.put(57922, c.a.emoji_264b);
    b.put(57923, c.a.emoji_264c);
    b.put(57924, c.a.emoji_264d);
    b.put(57925, c.a.emoji_264e);
    b.put(57926, c.a.emoji_264f);
    b.put(57927, c.a.emoji_2650);
    b.put(57928, c.a.emoji_2651);
    b.put(57929, c.a.emoji_2652);
    b.put(57930, c.a.emoji_2653);
    b.put(57931, c.a.emoji_26ce);
    b.put(57932, c.a.emoji_1f51d);
    b.put(57933, c.a.emoji_1f197);
    b.put(57936, c.a.emoji_1f4f3);
    b.put(57937, c.a.emoji_1f4f4);
    b.put(57938, c.a.emoji_26a0);
    b.put(57939, c.a.emoji_1f481);
    b.put(58114, c.a.emoji_1f454);
    b.put(58115, c.a.emoji_1f33a);
    b.put(58116, c.a.emoji_1f337);
    b.put(58117, c.a.emoji_1f33b);
    b.put(58118, c.a.emoji_1f490);
    b.put(58119, c.a.emoji_1f334);
    b.put(58120, c.a.emoji_1f335);
    b.put(58121, c.a.emoji_1f6be);
    b.put(58122, c.a.emoji_1f3a7);
    b.put(58123, c.a.emoji_1f376);
    b.put(58124, c.a.emoji_1f37b);
    b.put(58125, c.a.emoji_3297);
    b.put(58126, c.a.emoji_1f6ac);
    b.put(58127, c.a.emoji_1f48a);
    b.put(58128, c.a.emoji_1f388);
    b.put(58129, c.a.emoji_1f4a3);
    b.put(58130, c.a.emoji_1f389);
    b.put(58131, c.a.emoji_2702);
    b.put(58132, c.a.emoji_1f380);
    b.put(58133, c.a.emoji_3299);
    b.put(58134, c.a.emoji_1f4bd);
    b.put(58135, c.a.emoji_1f4e3);
    b.put(58136, c.a.emoji_1f452);
    b.put(58137, c.a.emoji_1f457);
    b.put(58138, c.a.emoji_1f461);
    b.put(58139, c.a.emoji_1f462);
    b.put(58140, c.a.emoji_1f484);
    b.put(58141, c.a.emoji_1f485);
    b.put(58142, c.a.emoji_1f486);
    b.put(58143, c.a.emoji_1f487);
    b.put(58144, c.a.emoji_1f488);
    b.put(58145, c.a.emoji_1f458);
    b.put(58146, c.a.emoji_1f459);
    b.put(58147, c.a.emoji_1f45c);
    b.put(58148, c.a.emoji_1f3ac);
    b.put(58149, c.a.emoji_1f514);
    b.put(58150, c.a.emoji_1f3b6);
    b.put(58152, c.a.emoji_1f48c);
    b.put(58153, c.a.emoji_1f498);
    b.put(58154, c.a.emoji_1f499);
    b.put(58155, c.a.emoji_1f49a);
    b.put(58156, c.a.emoji_1f49b);
    b.put(58157, c.a.emoji_1f49c);
    b.put(58158, c.a.emoji_2728);
    b.put(58159, c.a.emoji_2b50);
    b.put(58160, c.a.emoji_1f4a8);
    b.put(58161, c.a.emoji_1f4a6);
    b.put(58162, c.a.emoji_2b55);
    b.put(58164, c.a.emoji_1f4a2);
    b.put(58168, c.a.emoji_1f375);
    b.put(58169, c.a.emoji_1f35e);
    b.put(58170, c.a.emoji_1f366);
    b.put(58171, c.a.emoji_1f35f);
    b.put(58172, c.a.emoji_1f361);
    b.put(58173, c.a.emoji_1f358);
    b.put(58174, c.a.emoji_1f35a);
    b.put(58175, c.a.emoji_1f35d);
    b.put(58176, c.a.emoji_1f35c);
    b.put(58177, c.a.emoji_1f35b);
    b.put(58178, c.a.emoji_1f359);
    b.put(58179, c.a.emoji_1f362);
    b.put(58180, c.a.emoji_1f363);
    b.put(58181, c.a.emoji_1f34e);
    b.put(58182, c.a.emoji_1f34a);
    b.put(58183, c.a.emoji_1f353);
    b.put(58184, c.a.emoji_1f349);
    b.put(58186, c.a.emoji_1f346);
    b.put(58187, c.a.emoji_1f382);
    b.put(58188, c.a.emoji_1f371);
    b.put(58189, c.a.emoji_1f372);
    b.put(58369, c.a.emoji_1f625);
    b.put(58371, c.a.emoji_1f614);
    b.put(58372, c.a.emoji_1f601);
    b.put(58373, c.a.emoji_1f609);
    b.put(58374, c.a.emoji_1f623);
    b.put(58375, c.a.emoji_1f616);
    b.put(58376, c.a.emoji_1f62a);
    b.put(58379, c.a.emoji_1f628);
    b.put(58380, c.a.emoji_1f637);
    b.put(58381, c.a.emoji_1f633);
    b.put(58382, c.a.emoji_1f612);
    b.put(58383, c.a.emoji_1f630);
    b.put(58384, c.a.emoji_1f632);
    b.put(58385, c.a.emoji_1f62d);
    b.put(58386, c.a.emoji_1f602);
    b.put(58387, c.a.emoji_1f622);
    b.put(58388, c.a.emoji_263a);
    b.put(58390, c.a.emoji_1f621);
    b.put(58391, c.a.emoji_1f61a);
    b.put(58392, c.a.emoji_1f618);
    b.put(58393, c.a.emoji_1f440);
    b.put(58394, c.a.emoji_1f443);
    b.put(58395, c.a.emoji_1f442);
    b.put(58396, c.a.emoji_1f444);
    b.put(58397, c.a.emoji_1f64f);
    b.put(58398, c.a.emoji_1f44b);
    b.put(58399, c.a.emoji_1f44f);
    b.put(58400, c.a.emoji_1f44c);
    b.put(58401, c.a.emoji_1f44e);
    b.put(58402, c.a.emoji_1f450);
    b.put(58403, c.a.emoji_1f645);
    b.put(58404, c.a.emoji_1f646);
    b.put(58405, c.a.emoji_1f491);
    b.put(58406, c.a.emoji_1f647);
    b.put(58407, c.a.emoji_1f64c);
    b.put(58408, c.a.emoji_1f46b);
    b.put(58409, c.a.emoji_1f46f);
    b.put(58410, c.a.emoji_1f3c0);
    b.put(58411, c.a.emoji_1f3c8);
    b.put(58412, c.a.emoji_1f3b1);
    b.put(58413, c.a.emoji_1f3ca);
    b.put(58414, c.a.emoji_1f699);
    b.put(58415, c.a.emoji_1f69a);
    b.put(58416, c.a.emoji_1f692);
    b.put(58417, c.a.emoji_1f691);
    b.put(58418, c.a.emoji_1f693);
    b.put(58419, c.a.emoji_1f3a2);
    b.put(58420, c.a.emoji_1f687);
    b.put(58421, c.a.emoji_1f684);
    b.put(58422, c.a.emoji_1f38d);
    b.put(58423, c.a.emoji_1f49d);
    b.put(58424, c.a.emoji_1f38e);
    b.put(58426, c.a.emoji_1f392);
    b.put(58427, c.a.emoji_1f38f);
    b.put(58428, c.a.emoji_1f302);
    b.put(58429, c.a.emoji_1f492);
    b.put(58430, c.a.emoji_1f30a);
    b.put(58431, c.a.emoji_1f367);
    b.put(58432, c.a.emoji_1f387);
    b.put(58433, c.a.emoji_1f41a);
    b.put(58434, c.a.emoji_1f390);
    b.put(58435, c.a.emoji_1f300);
    b.put(58436, c.a.emoji_1f33e);
    b.put(58437, c.a.emoji_1f383);
    b.put(58438, c.a.emoji_1f391);
    b.put(58439, c.a.emoji_1f343);
    b.put(58440, c.a.emoji_1f385);
    b.put(58441, c.a.emoji_1f305);
    b.put(58442, c.a.emoji_1f307);
    b.put(58443, c.a.emoji_1f303);
    b.put(58444, c.a.emoji_1f308);
    b.put(58625, c.a.emoji_1f3e9);
    b.put(58626, c.a.emoji_1f3a8);
    b.put(58627, c.a.emoji_1f3a9);
    b.put(58628, c.a.emoji_1f3ec);
    b.put(58629, c.a.emoji_1f3ef);
    b.put(58630, c.a.emoji_1f3f0);
    b.put(58631, c.a.emoji_1f3a6);
    b.put(58632, c.a.emoji_1f3ed);
    b.put(58633, c.a.emoji_1f5fc);
    b.put(58635, c.a.emoji_1f1ef_1f1f5);
    b.put(58636, c.a.emoji_1f1fa_1f1f8);
    b.put(58637, c.a.emoji_1f1eb_1f1f7);
    b.put(58638, c.a.emoji_1f1e9_1f1ea);
    b.put(58639, c.a.emoji_1f1ee_1f1f9);
    b.put(58640, c.a.emoji_1f1ec_1f1e7);
    b.put(58641, c.a.emoji_1f1ea_1f1f8);
    b.put(58642, c.a.emoji_1f1f7_1f1fa);
    b.put(58643, c.a.emoji_1f1e8_1f1f3);
    b.put(58644, c.a.emoji_1f1f0_1f1f7);
    b.put(58645, c.a.emoji_1f471);
    b.put(58646, c.a.emoji_1f472);
    b.put(58648, c.a.emoji_1f474);
    b.put(58649, c.a.emoji_1f475);
    b.put(58650, c.a.emoji_1f476);
    b.put(58651, c.a.emoji_1f477);
    b.put(58652, c.a.emoji_1f478);
    b.put(58653, c.a.emoji_1f5fd);
    b.put(58654, c.a.emoji_1f482);
    b.put(58655, c.a.emoji_1f483);
    b.put(58656, c.a.emoji_1f42c);
    b.put(58657, c.a.emoji_1f426);
    b.put(58658, c.a.emoji_1f420);
    b.put(58660, c.a.emoji_1f439);
    b.put(58661, c.a.emoji_1f41b);
    b.put(58662, c.a.emoji_1f418);
    b.put(58663, c.a.emoji_1f428);
    b.put(58664, c.a.emoji_1f412);
    b.put(58665, c.a.emoji_1f411);
    b.put(58666, c.a.emoji_1f43a);
    b.put(58667, c.a.emoji_1f42e);
    b.put(58668, c.a.emoji_1f430);
    b.put(58669, c.a.emoji_1f40d);
    b.put(58670, c.a.emoji_1f414);
    b.put(58671, c.a.emoji_1f417);
    b.put(58672, c.a.emoji_1f42b);
    b.put(58673, c.a.emoji_1f438);
    b.put(58674, c.a.emoji_1f170);
    b.put(58675, c.a.emoji_1f171);
    b.put(58676, c.a.emoji_1f18e);
    b.put(58677, c.a.emoji_1f17e);
    b.put(58679, c.a.emoji_2122);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    default: 
      return 0;
    case 35: 
      return c.a.emoji_0023;
    case 42: 
      return c.a.emoji_002a_20e3;
    case 48: 
      return c.a.emoji_0030;
    case 49: 
      return c.a.emoji_0031;
    case 50: 
      return c.a.emoji_0032;
    case 51: 
      return c.a.emoji_0033;
    case 52: 
      return c.a.emoji_0034;
    case 53: 
      return c.a.emoji_0035;
    case 54: 
      return c.a.emoji_0036;
    case 55: 
      return c.a.emoji_0037;
    case 56: 
      return c.a.emoji_0038;
    }
    return c.a.emoji_0039;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return ((0xD800 ^ paramInt1) << 2 | (paramInt2 ^ 0xDC00) >> 8) << 8 | ((paramInt2 ^ 0xDC00) & 0xFF) + 65536;
  }
  
  private static int a(Context paramContext, int paramInt)
  {
    return a.get(paramInt);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, paramString.length());
  }
  
  private static String a(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    char c1;
    int k;
    int j;
    if (m < paramInt)
    {
      c1 = paramString.charAt(m);
      if (!a(c1)) {
        break label483;
      }
      k = b(c1);
      if (k == 0) {
        j = 0;
      }
    }
    for (;;)
    {
      label46:
      int i = k;
      int i1;
      int n;
      if (k == 0)
      {
        i1 = Character.codePointAt(paramString, m);
        n = Character.charCount(i1);
        i = k;
        if (i1 > 255) {
          i = a(paramContext, i1);
        }
        if (m + n >= paramInt) {
          break label476;
        }
        j = Character.codePointAt(paramString, m + n);
        if (j != 65039) {
          break label240;
        }
        k = Character.charCount(j);
        if (m + n + k >= paramInt) {
          break label476;
        }
        j = Character.codePointAt(paramString, m + n + k);
        if (j != 8419) {
          break label476;
        }
        j = Character.charCount(j);
        i1 = a(i1);
        if (i1 != 0) {
          break label233;
        }
        j = 0;
        k = 0;
        label184:
        j = j + k + n;
      }
      for (;;)
      {
        if (i > 0) {
          localStringBuilder.append(a(a(paramString, paramInt, m, j)));
        }
        for (;;)
        {
          m = j + m;
          break;
          j = 1;
          break label46;
          label233:
          i = i1;
          break label184;
          label240:
          if (j == 8419)
          {
            j = Character.charCount(j);
            k = a(i1);
            if (k == 0) {
              j = 0;
            }
            for (;;)
            {
              j += n;
              break;
              i = k;
            }
          }
          k = Character.charCount(j);
          String str1 = Integer.toHexString(i1);
          String str2 = Integer.toHexString(j);
          str1 = "emoji_" + str1 + "_" + str2;
          if (d.containsKey(str1))
          {
            j = ((Integer)d.get(str1)).intValue();
            label373:
            if (j != 0) {
              break label444;
            }
          }
          for (j = 0;; j = k)
          {
            j += n;
            break;
            i1 = paramContext.getResources().getIdentifier(str1, "drawable", paramContext.getApplicationContext().getPackageName());
            j = i1;
            if (i1 == 0) {
              break label373;
            }
            d.put(str1, Integer.valueOf(i1));
            j = i1;
            break label373;
            label444:
            i = j;
          }
          if (i == 0) {
            localStringBuilder.append(c1);
          }
        }
        return localStringBuilder.toString();
        label476:
        j = n;
      }
      label483:
      k = 0;
      j = 0;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramString.length() >= 2)
    {
      String str = null;
      int i = 0;
      if ((i < paramString.length() / 2) && (paramString.length() % 2 == 0))
      {
        if ((paramString.charAt(i) & 0xFF00) == 0) {
          str = Integer.toHexString(paramString.codePointAt(i * 2)) + "-" + Integer.toHexString(paramString.codePointAt(i * 2 + 1));
        }
        for (;;)
        {
          i += 1;
          break;
          if (i == 0) {
            str = Integer.toHexString(a(paramString.charAt(i * 2), paramString.charAt(i * 2 + 1)));
          } else {
            str = "-" + Integer.toHexString(a(paramString.charAt(i * 2), paramString.charAt(i * 2 + 1)));
          }
        }
      }
      return "{" + str + "}";
    }
    return "{" + Integer.toHexString(paramString.charAt(0)) + "}";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while ((paramInt2 < paramInt1) && (paramInt3 > 0))
    {
      paramInt3 -= 1;
      localStringBuilder.append(String.valueOf(paramString.charAt(paramInt2)));
      paramInt2 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramSpannable == null)) {
      return;
    }
    int i = paramSpannable.length();
    if ((paramInt5 < 0) || (paramInt5 >= i - paramInt4)) {}
    Object localObject;
    int k;
    for (int j = i;; j = paramInt5 + paramInt4)
    {
      localObject = (b[])paramSpannable.getSpans(0, i, b.class);
      paramInt5 = 0;
      for (;;)
      {
        k = paramInt4;
        if (paramInt5 >= localObject.length) {
          break;
        }
        paramSpannable.removeSpan(localObject[paramInt5]);
        paramInt5 += 1;
      }
    }
    label99:
    label145:
    int n;
    int m;
    int i1;
    if (k < j)
    {
      i = 0;
      paramInt4 = 0;
      char c1 = paramSpannable.charAt(k);
      if (a(c1))
      {
        paramInt5 = b(c1);
        if (paramInt5 != 0) {
          break label351;
        }
        paramInt4 = 0;
        i = paramInt4;
        paramInt4 = paramInt5;
      }
      paramInt5 = paramInt4;
      if (paramInt4 != 0) {
        break label599;
      }
      n = Character.codePointAt(paramSpannable, k);
      m = Character.charCount(n);
      if (n > 255) {
        paramInt4 = a(paramContext, n);
      }
      paramInt5 = paramInt4;
      i = m;
      if (k + m >= j) {
        break label599;
      }
      i1 = Character.codePointAt(paramSpannable, k + m);
      if (i1 != 65039) {
        break label364;
      }
      i = Character.charCount(i1);
      if (k + m + i >= j) {
        break label610;
      }
      paramInt5 = Character.codePointAt(paramSpannable, k + m + i);
      if (paramInt5 != 8419) {
        break label610;
      }
      paramInt5 = Character.charCount(paramInt5);
      n = a(n);
      if (n != 0) {
        break label357;
      }
      i = 0;
      paramInt5 = 0;
      label297:
      paramInt5 = paramInt5 + i + m;
    }
    for (;;)
    {
      if (paramInt4 > 0) {
        paramSpannable.setSpan(new b(paramContext, paramInt4, paramInt1, paramInt2, paramInt3), k, k + paramInt5, 33);
      }
      k += paramInt5;
      break label99;
      break;
      label351:
      paramInt4 = 1;
      break label145;
      label357:
      paramInt4 = n;
      break label297;
      label364:
      if (i1 == 8419)
      {
        paramInt5 = Character.charCount(i1);
        i = a(n);
        if (i == 0) {
          paramInt5 = 0;
        }
        for (;;)
        {
          paramInt5 = m + paramInt5;
          break;
          paramInt4 = i;
        }
      }
      paramInt5 = paramInt4;
      i = m;
      if (c.get(i1, 0) > 0)
      {
        i = Character.charCount(i1);
        localObject = Integer.toHexString(n);
        String str = Integer.toHexString(i1);
        localObject = "emoji_" + (String)localObject + "_" + str;
        if (d.containsKey(localObject))
        {
          paramInt5 = ((Integer)d.get(localObject)).intValue();
          label517:
          if (paramInt5 != 0) {
            break label588;
          }
        }
        for (paramInt5 = 0;; paramInt5 = i)
        {
          paramInt5 = m + paramInt5;
          break;
          n = paramContext.getResources().getIdentifier((String)localObject, "drawable", paramContext.getApplicationContext().getPackageName());
          paramInt5 = n;
          if (n == 0) {
            break label517;
          }
          d.put(localObject, Integer.valueOf(n));
          paramInt5 = n;
          break label517;
          label588:
          paramInt4 = paramInt5;
        }
      }
      label599:
      paramInt4 = paramInt5;
      paramInt5 = i;
      continue;
      label610:
      paramInt5 = m;
    }
  }
  
  public static void a(Context paramContext, Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramSpannable, paramInt1, paramInt2, paramInt3, 0, -1, paramBoolean);
  }
  
  private static boolean a(char paramChar)
  {
    return paramChar >> '\f' == 14;
  }
  
  private static int b(char paramChar)
  {
    return b.get(paramChar);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\io\github\rockerhieu\emojicon\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */