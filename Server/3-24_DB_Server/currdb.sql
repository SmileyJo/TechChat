--
-- File generated with SQLiteStudio v3.1.1 on Fri Mar 24 11:44:22 2017
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Conversation
CREATE TABLE Conversation (c_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, u_One INT (11) NOT NULL REFERENCES Users (User_ID), u_Two INT (11) REFERENCES Users (User_ID) NOT NULL, time INT (11) DEFAULT NULL);
INSERT INTO Conversation (c_ID, u_One, u_Two, time) VALUES (1, 13603515, 13, '11:33');
INSERT INTO Conversation (c_ID, u_One, u_Two, time) VALUES (2, 2, 13, '11:22');

-- Table: Deleted_Users_Log
CREATE TABLE Deleted_Users_Log (u_ID INT (11) NOT NULL PRIMARY KEY UNIQUE, Username VARCHAR (30) NOT NULL UNIQUE, Password VARCHAR (50) NOT NULL, Email VARCHAR (100) NOT NULL);
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (2, 'chicken', 'chicken123', 'chicken@gmail.com');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (3, 'lettuce', 'lettuce123', 'lettuce@gmail.com');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (70802384, 'p39aofg74xaoju b	 
x', '6a7vf	mlmj', '5lic2nxe23m27');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (35962978, '
 4cn797w3em', 'r9t2	8dzpiweuqr', 'kp	  38c	
wg0 ');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (17039925, 'clz ', '8pxx0eacbpq1xai', 'wajmklfoz
a 3');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (75075954, 'k9hcq4jaj', 'uesf1g5m
j', 'yy77f 1nl04ji9	8z02');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (30955483, '  	7hgmke
', 'kke0yxa', 'okk7 7r2qv2tp7 0rp	x');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (84952825, 'kb8liejh5say1yysskja', ' wv
67  o3', 'pzulu1dqg7');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (21998338, 'v4
15umxsyq', 'pfo5ybdtax6', 'yst
tm5	t6m');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (51355217, 'nv oo8hyrgw', '3crgho4bywca', 'js649xq5gb');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (80628697, 'm2r0s6 ', 'cjzzt9qv34qiw', 'quf265er4z6c2p	');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (48628274, '4y8soy vdx', '19o0e', 'mnf1m1qw
a9');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (13603515, 'ffo
w
', 'gu99rb4h4c1u', 'xb9 q');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (44945700, 'l6xo', 'or6udxvdx30ipat8y
ho', 'gt6y
pbhsp3t');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (69572870, 'u5	jm53m0', 'gs10msya1j3rm1bc67z4', 'e8f6te0kjwh');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (90213706, ' ia8o6do5nyk8j3m', 'pf2c', 'dwni0widheu 3exr0');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (57146396, ' 4nl', 's2uortcjazcdu5', 'e
9r6');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (83392423, 'qkh7hl0', 'h	c	4cz', 'u2shq9nilu');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (18450629, '3j0jg', 'w
7k	ukjurposur
62i', 'ah5
3ypp41ouvlccsw');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (82970051, 'lss1uh1iq9l4777s', 'c afg6
	s9c59kl6', '3pl4	 fqmth x');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (34975966, '98vz83psl7td ctv6', '082gxv', '554uqveupo');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (27321987, 'pxms7f', 'atk0jc 32 6f', 'i92pa4dsc66g');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (8832508, '8
0kdqy1fcz7jy9rv', '26733	7ekhq j', '3q75e');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (30683880, 'il	72gb', 'xsfti570bbu0n ', '3dtxbpsj3dty9vys0y ');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (88071095, 'qlywfj
i3junc', 'gzgkdxuu41jqhz', 'hjh9s5f y h');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (14149221, 'udn3lrhbi361hlwdbox', 'nl39a3d6y', 'ytiw84i6eqp45 mv6');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (25393187, '6i891vyzm77	gu5cj', 'ggt7s7j901h', '6kt
2i');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (42971758, '2l8r30jfzanuozz', '1
jdg ', '4dio7');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (90942490, 'jcvdgkqrb3	f3
w', 'vz0i9l56z', 'ovxlp');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (47632968, 'b7ek', 'vg s21hl1c5ucj', 'v6287a2swljh45ahou0');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (55947813, '5vbreyah1qfz', '5t
uskoo4blq68gg', 'opubx8onr5jxhxkh4');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (77126703, 'xpr70y', '7nris55czgp61yx', '	5u	psmyvpuuqp	');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (95221498, '0ib0ky8jos4tavxt', 'a8d9cfow24kjejp', '5tq1cyq');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (74942114, 'cg6y0xp4is5x8', 'g6
		4z14 hju 
', '
ugx0uwh1901ur');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (3078826, '2tm7u45kqw
fx', 'y9
y3yzf', 'cirlh');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (99095467, 'mo3pf
co
rpvn2j81', 'ijy6', 'nimb6ns2mnvn76izi8gq');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (67446322, 'b8am	ad', '6eumnb48l', 'ptkrfmbflqxlhv7vd');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (1694855, 'ego0q', 'ax01zqx i	x
p', 'zmp5');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (79864310, 'twj63em6 x4u41', '6mkiseyyv', 'opb
go8hmz67');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (63563305, 'd7yg4rrn0387pox		j4z', 'cw9h4', ' 
wjke3kcgf
hl o4');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (51248576, 'vuvgekbn4u8', 'bbt
sxlqoe1w	9h', '8
87dga
m');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (32737570, ' 6apjvlan0gglluq ', 'wbdf2ma
', 'i10p8576pgc10bbtazzd');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (55568424, 'osur17rh65
pbzz1 in', 'ytyf3iciva9a
 o1
nsv', 'x
xwt');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (76122706, '8in57', 'kq8wtgvd6', '0ixyk42
w39kobiw');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (7552902, 'i 46ws7', 'yvfae7', '3 1ra m26');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (40918826, '12h5lzcdxadtec91q', '7cbuz3h4vt', '2t
h9y2euig3');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (69253056, 'c0lqg4g6	l1ca	8ln', 'tmyr68	hduxjgnqm5', '2jny14');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (30120918, '7dcnf8fh', '61  pjpqamlq18mh', '7f	fhkr');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (50285482, 'q7tabp9zrh1y', 'b0mga8jgok	89r', 'dnaxlh	s1vqk6gb5axs');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (98253925, 'cbzrh	tp5u7eci', ' 	85ea3ihh jqgjq7k4g', 'es22vwt68');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (64810263, 'vjt
p6', 'st3hly', 'ddtippu5sr');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (15476208, 'y63xo7pgg5', '62ue	8xbs z', 'ckg82h	xtzawdmd073');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (13922021, 'c tmust4ld1d3p', 'prmkkouds', 'gy0vcfxn01j6to');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (98382485, 'bgxsxo1y', 'lydyo36', 'hfm8 bxi0	gms');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (311298, 'iyp5f', '5wvxz4
p c3c', 'r4meauumqc4weof1a');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (50966538, 'engy99', '5j89idx05s7e', '63fcw');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (83398276, '7uecshp	q	', 'rt4qzb', 'g54o6fpiuq15');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (27840322, '5kb	qh0egz91g', 'u89qxcm1x7mvn ', 'beofjwtkgv
ef4');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (20669672, 't
f2hwbw9nn8c1x888i', '5kt5cb25log6kfx9c	
', 'cr
j');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (19067488, 's3x
', '37buekf1zdpkxi	4l81', '157	6xxaaza');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (32081963, '7nioo81i', 'r2avw', '9a7z');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (79019811, 'nw25', 'exw7 53', '7jqs8	mwppjrzcs3x');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (50218492, '
6xkf27kor', 'lf08	602xmvb5iz9y', 'cf0y');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (1057885, 'r974 suw
i', 'nwne4z
2uxb9uj', 'i7yl66ivmvixs');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (95287996, '3haj26m6tjip ch', 'p7b5ng5vc0u0tsdv2hk', '5v175s81
v1px');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (45361020, '9dxi9l8ox3a	j0	q16v
', '0wezuplbwn5q', '513nf9ok	4h1oi');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (90163223, 'o8
lzq1ma', 'luvmuz7j44', '65mhe
1tg');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (29589835, 'e9xy9	2n', 'nh8z', 'zu18xankapu3tlq');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (3597131, 'gzwrv	3k715a	 ddpk', 'k7k68j2', 'vqn swcl6gq8');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (65072670, 'y365sqcv59z2a', 'nbdts4scx74ggoe8x', 'p p9ho');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (73725930, 'f6c	jv', 'w11qio', 'xcz1jwm0
xac');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (87163922, 'qa72w6', 'qhb4wph	g	liw', 'edfv');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (40468436, 'hc0h', 'l0gww 4n5 ', 'e
 0u');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (18923829, 'lar2u6arc3dckuxn4', '0czctx9vlrba811z', 'gh	k');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (88989870, 'lztjg6rz3zh3', 'i	pxvk ew74aky8e', '763p120wm5hofc');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (268221, 'bohgv', 'ydifii65ldtij96', 'hrj mqzfq9rgxna29');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (95118407, 'j1y8860yuum', '
r79  3gf
sm', 'qov61t	35');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (48015211, '36 6be	2z10vlpyvgv', 'od 553kyacrf', '4v 9 5');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (73876465, 'xnzxm9gt97edlv7wtc78', 'us7ixm2ziaz8f', 'lb69a8otzp5ix5n	m3');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (35683744, '09	u629wc3ee2a84lj', 'phikdyrcwqr9o1t', '0fut	i7ygsj');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (66366294, 'wxdnwmaiu98o', '28ma9ed2ld8dmivn3', '3c132');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (77257374, 'ym 33', 'rcmqlq3	2yjrjrw', '  l5o4s5p5p');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (99603927, '080v6zz61tzp65
', '70kpuc6qsntos
s0pg', '6kgk
	wb7');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (41295289, 'srj2
z
vbdzqqrdr5iay', 'b6frptsow1jis', 'she2rm
1a5t4');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (70567837, 'ljsij1feix1', 'aj58tkyg4rx557mwbe ', '5u3f
9bk17ui wtnm07');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (86534791, 'hcvk7a3k', 'f3 hck', 'nb1pptplkv9w');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (96078272, 'npdfo5em4t	jf	ggwt', 'lcu52if66q4u', '9ced3ngbme');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (23758233, '38c4t', '6hj0ieix961en1o0b', 'fvhipwlv1');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (87919526, 'sxf17	dts4m79u0q', '4vq8', 'bqdyyro6hema8e5');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (7443172, 'svbnj4duvqelo4hzphhc', '5xla37ocgka5l', 'uoy32	9qnjvowai4r');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (99159160, 'dmpng1f', 't
1vnqhimblwg a', 'a
x
igpwjb6ggd6');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (1892807, '7l	nc
815k', 'ukz9e	apt3shnvjrozdf', '5	h15h30el5 2t03gmq');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (60475758, 'z84ep15x', ' cpyl', 'b2dmuj mkg83gujiv1');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (16561093, 'q	6n3txe31ueqfevv0a', '0s	mnr', 'rxjmqez4n		2c');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (8189356, 'q7y	p7', 'fy93zfqc', 'q1xi4v9m39g 38m6c
f9');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (9981972, 'osn9 ', 't0gqi qo4l
m72x', 'zofq5m1q
s87xokra');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (8212478, '5yntwbgst', '3hk7p1 8q
qk j', 'f
p	16t');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (17482445, 'qt8	e3i
9
9	r0wdue5z', '
kw7b	', '27cf
vnip23');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (8419335, 'qh0jdvva8uo0cccg6', 'l7z bg', 'n9w4vxnm8e1u6g8');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (87664660, 'xvwe6', 'dqc4 2t0', 'e
6
6y0ltcjba0pw');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (11051689, 'ellw2 vty', 'jb9vx0h6q', 'sbt7qc	o');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (40705740, '	8m
5', '7 8q17k817', 'zakdgsw');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (13, 'JamesDitka', 'apple', 'apple@gmail.com');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (50264357, 'bp0z9mphl0mqwj6ef2s', 'mpqpbykl 6	150q', 'zq8lo134posi2 sf2');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (10310840, '2bfntpy3s', 'm
cfr xi0gkh223	xm
q', 'rbzf	fm1');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (35754385, 'uko3bq
nqi0', 'n6cmsgkfnsaah0x', 'po 8rl3csx');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (19300898, '46kr8dn', '5	qt2w iug', 'vmhsf1l2t8aifeqfoe');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (22640302, 'pa7xc46cssdv12ra
2', 'ixtmb', 's6f36 7g41n07mg1hj');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (82060314, 'ftxyg	2c0wib
ttn', 'z16qbkvrxr9iz4k7
1k', 'f0d7e2c');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (90247466, '8zrolhddhf
s 2', 'c2a5b3uk23	35uskc97p', 'hjrgf
');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (71708611, 'ny9m98hak4r		eihk', 'h1lileb3adwx53tgbeu2', 'vnnsrgegf	cv
9l	p0l');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (74087435, '69df9rvl5c8', '7	fhrdkq 2
rvrtv', '4cjvfj0581');
INSERT INTO Deleted_Users_Log (u_ID, Username, Password, Email) VALUES (22059668, 'evk33niaqlxq4fhc0', 'ucn6sfy5deg0qup
td', 's6i0hder7qolqx1');

-- Table: Reply
CREATE TABLE Reply (r_ID INT (11) PRIMARY KEY NOT NULL, reply TEXT NOT NULL, user_fk_ID INT (11) REFERENCES Users (User_ID) NOT NULL, c_fk_ID INT (11) REFERENCES Conversation (c_ID) NOT NULL, time INT (11) DEFAULT NULL);

-- Table: Users
CREATE TABLE Users (User_ID INT (11) PRIMARY KEY NOT NULL UNIQUE, Username VARCHAR (30) NOT NULL UNIQUE, Password VARCHAR (50) NOT NULL, Email VARCHAR (100) NOT NULL);
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (2, 'chicken', 'chicken123', 'chicken@gmail.com');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (3, 'lettuce', 'lettuce123', 'lettuce@gmail.com');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (70802384, 'p39aofg74xaoju b	 
x', '6a7vf	mlmj', '5lic2nxe23m27');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (35962978, '
 4cn797w3em', 'r9t2	8dzpiweuqr', 'kp	  38c	
wg0 ');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (17039925, 'clz ', '8pxx0eacbpq1xai', 'wajmklfoz
a 3');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (75075954, 'k9hcq4jaj', 'uesf1g5m
j', 'yy77f 1nl04ji9	8z02');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (30955483, '  	7hgmke
', 'kke0yxa', 'okk7 7r2qv2tp7 0rp	x');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (84952825, 'kb8liejh5say1yysskja', ' wv
67  o3', 'pzulu1dqg7');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (21998338, 'v4
15umxsyq', 'pfo5ybdtax6', 'yst
tm5	t6m');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (51355217, 'nv oo8hyrgw', '3crgho4bywca', 'js649xq5gb');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (80628697, 'm2r0s6 ', 'cjzzt9qv34qiw', 'quf265er4z6c2p	');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (48628274, '4y8soy vdx', '19o0e', 'mnf1m1qw
a9');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (13603515, 'ffo
w
', 'gu99rb4h4c1u', 'xb9 q');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (44945700, 'l6xo', 'or6udxvdx30ipat8y
ho', 'gt6y
pbhsp3t');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (69572870, 'u5	jm53m0', 'gs10msya1j3rm1bc67z4', 'e8f6te0kjwh');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (90213706, ' ia8o6do5nyk8j3m', 'pf2c', 'dwni0widheu 3exr0');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (57146396, ' 4nl', 's2uortcjazcdu5', 'e
9r6');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (83392423, 'qkh7hl0', 'h	c	4cz', 'u2shq9nilu');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (18450629, '3j0jg', 'w
7k	ukjurposur
62i', 'ah5
3ypp41ouvlccsw');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (82970051, 'lss1uh1iq9l4777s', 'c afg6
	s9c59kl6', '3pl4	 fqmth x');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (34975966, '98vz83psl7td ctv6', '082gxv', '554uqveupo');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (27321987, 'pxms7f', 'atk0jc 32 6f', 'i92pa4dsc66g');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (8832508, '8
0kdqy1fcz7jy9rv', '26733	7ekhq j', '3q75e');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (30683880, 'il	72gb', 'xsfti570bbu0n ', '3dtxbpsj3dty9vys0y ');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (88071095, 'qlywfj
i3junc', 'gzgkdxuu41jqhz', 'hjh9s5f y h');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (14149221, 'udn3lrhbi361hlwdbox', 'nl39a3d6y', 'ytiw84i6eqp45 mv6');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (25393187, '6i891vyzm77	gu5cj', 'ggt7s7j901h', '6kt
2i');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (42971758, '2l8r30jfzanuozz', '1
jdg ', '4dio7');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (90942490, 'jcvdgkqrb3	f3
w', 'vz0i9l56z', 'ovxlp');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (47632968, 'b7ek', 'vg s21hl1c5ucj', 'v6287a2swljh45ahou0');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (55947813, '5vbreyah1qfz', '5t
uskoo4blq68gg', 'opubx8onr5jxhxkh4');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (77126703, 'xpr70y', '7nris55czgp61yx', '	5u	psmyvpuuqp	');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (95221498, '0ib0ky8jos4tavxt', 'a8d9cfow24kjejp', '5tq1cyq');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (74942114, 'cg6y0xp4is5x8', 'g6
		4z14 hju 
', '
ugx0uwh1901ur');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (3078826, '2tm7u45kqw
fx', 'y9
y3yzf', 'cirlh');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (99095467, 'mo3pf
co
rpvn2j81', 'ijy6', 'nimb6ns2mnvn76izi8gq');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (67446322, 'b8am	ad', '6eumnb48l', 'ptkrfmbflqxlhv7vd');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (1694855, 'ego0q', 'ax01zqx i	x
p', 'zmp5');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (79864310, 'twj63em6 x4u41', '6mkiseyyv', 'opb
go8hmz67');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (63563305, 'd7yg4rrn0387pox		j4z', 'cw9h4', ' 
wjke3kcgf
hl o4');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (51248576, 'vuvgekbn4u8', 'bbt
sxlqoe1w	9h', '8
87dga
m');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (32737570, ' 6apjvlan0gglluq ', 'wbdf2ma
', 'i10p8576pgc10bbtazzd');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (55568424, 'osur17rh65
pbzz1 in', 'ytyf3iciva9a
 o1
nsv', 'x
xwt');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (76122706, '8in57', 'kq8wtgvd6', '0ixyk42
w39kobiw');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (7552902, 'i 46ws7', 'yvfae7', '3 1ra m26');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (40918826, '12h5lzcdxadtec91q', '7cbuz3h4vt', '2t
h9y2euig3');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (69253056, 'c0lqg4g6	l1ca	8ln', 'tmyr68	hduxjgnqm5', '2jny14');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (30120918, '7dcnf8fh', '61  pjpqamlq18mh', '7f	fhkr');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (50285482, 'q7tabp9zrh1y', 'b0mga8jgok	89r', 'dnaxlh	s1vqk6gb5axs');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (98253925, 'cbzrh	tp5u7eci', ' 	85ea3ihh jqgjq7k4g', 'es22vwt68');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (64810263, 'vjt
p6', 'st3hly', 'ddtippu5sr');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (15476208, 'y63xo7pgg5', '62ue	8xbs z', 'ckg82h	xtzawdmd073');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (13922021, 'c tmust4ld1d3p', 'prmkkouds', 'gy0vcfxn01j6to');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (98382485, 'bgxsxo1y', 'lydyo36', 'hfm8 bxi0	gms');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (311298, 'iyp5f', '5wvxz4
p c3c', 'r4meauumqc4weof1a');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (50966538, 'engy99', '5j89idx05s7e', '63fcw');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (83398276, '7uecshp	q	', 'rt4qzb', 'g54o6fpiuq15');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (27840322, '5kb	qh0egz91g', 'u89qxcm1x7mvn ', 'beofjwtkgv
ef4');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (20669672, 't
f2hwbw9nn8c1x888i', '5kt5cb25log6kfx9c	
', 'cr
j');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (19067488, 's3x
', '37buekf1zdpkxi	4l81', '157	6xxaaza');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (32081963, '7nioo81i', 'r2avw', '9a7z');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (79019811, 'nw25', 'exw7 53', '7jqs8	mwppjrzcs3x');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (50218492, '
6xkf27kor', 'lf08	602xmvb5iz9y', 'cf0y');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (1057885, 'r974 suw
i', 'nwne4z
2uxb9uj', 'i7yl66ivmvixs');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (95287996, '3haj26m6tjip ch', 'p7b5ng5vc0u0tsdv2hk', '5v175s81
v1px');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (45361020, '9dxi9l8ox3a	j0	q16v
', '0wezuplbwn5q', '513nf9ok	4h1oi');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (90163223, 'o8
lzq1ma', 'luvmuz7j44', '65mhe
1tg');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (29589835, 'e9xy9	2n', 'nh8z', 'zu18xankapu3tlq');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (3597131, 'gzwrv	3k715a	 ddpk', 'k7k68j2', 'vqn swcl6gq8');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (65072670, 'y365sqcv59z2a', 'nbdts4scx74ggoe8x', 'p p9ho');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (73725930, 'f6c	jv', 'w11qio', 'xcz1jwm0
xac');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (87163922, 'qa72w6', 'qhb4wph	g	liw', 'edfv');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (40468436, 'hc0h', 'l0gww 4n5 ', 'e
 0u');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (18923829, 'lar2u6arc3dckuxn4', '0czctx9vlrba811z', 'gh	k');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (88989870, 'lztjg6rz3zh3', 'i	pxvk ew74aky8e', '763p120wm5hofc');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (268221, 'bohgv', 'ydifii65ldtij96', 'hrj mqzfq9rgxna29');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (95118407, 'j1y8860yuum', '
r79  3gf
sm', 'qov61t	35');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (48015211, '36 6be	2z10vlpyvgv', 'od 553kyacrf', '4v 9 5');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (73876465, 'xnzxm9gt97edlv7wtc78', 'us7ixm2ziaz8f', 'lb69a8otzp5ix5n	m3');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (35683744, '09	u629wc3ee2a84lj', 'phikdyrcwqr9o1t', '0fut	i7ygsj');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (66366294, 'wxdnwmaiu98o', '28ma9ed2ld8dmivn3', '3c132');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (77257374, 'ym 33', 'rcmqlq3	2yjrjrw', '  l5o4s5p5p');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (99603927, '080v6zz61tzp65
', '70kpuc6qsntos
s0pg', '6kgk
	wb7');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (41295289, 'srj2
z
vbdzqqrdr5iay', 'b6frptsow1jis', 'she2rm
1a5t4');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (70567837, 'ljsij1feix1', 'aj58tkyg4rx557mwbe ', '5u3f
9bk17ui wtnm07');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (86534791, 'hcvk7a3k', 'f3 hck', 'nb1pptplkv9w');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (96078272, 'npdfo5em4t	jf	ggwt', 'lcu52if66q4u', '9ced3ngbme');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (23758233, '38c4t', '6hj0ieix961en1o0b', 'fvhipwlv1');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (87919526, 'sxf17	dts4m79u0q', '4vq8', 'bqdyyro6hema8e5');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (7443172, 'svbnj4duvqelo4hzphhc', '5xla37ocgka5l', 'uoy32	9qnjvowai4r');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (99159160, 'dmpng1f', 't
1vnqhimblwg a', 'a
x
igpwjb6ggd6');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (1892807, '7l	nc
815k', 'ukz9e	apt3shnvjrozdf', '5	h15h30el5 2t03gmq');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (60475758, 'z84ep15x', ' cpyl', 'b2dmuj mkg83gujiv1');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (16561093, 'q	6n3txe31ueqfevv0a', '0s	mnr', 'rxjmqez4n		2c');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (8189356, 'q7y	p7', 'fy93zfqc', 'q1xi4v9m39g 38m6c
f9');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (9981972, 'osn9 ', 't0gqi qo4l
m72x', 'zofq5m1q
s87xokra');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (8212478, '5yntwbgst', '3hk7p1 8q
qk j', 'f
p	16t');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (17482445, 'qt8	e3i
9
9	r0wdue5z', '
kw7b	', '27cf
vnip23');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (8419335, 'qh0jdvva8uo0cccg6', 'l7z bg', 'n9w4vxnm8e1u6g8');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (87664660, 'xvwe6', 'dqc4 2t0', 'e
6
6y0ltcjba0pw');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (11051689, 'ellw2 vty', 'jb9vx0h6q', 'sbt7qc	o');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (40705740, '	8m
5', '7 8q17k817', 'zakdgsw');
INSERT INTO Users (User_ID, Username, Password, Email) VALUES (13, 'JamesDitka', 'apple', 'apple@gmail.com');

-- Trigger: User_Delete
CREATE TRIGGER User_Delete AFTER DELETE ON Users FOR EACH ROW BEGIN INSERT INTO Deleted_Users_Log SELECT * FROM Users; END;

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
