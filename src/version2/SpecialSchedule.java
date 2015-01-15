package version2;

public class SpecialSchedule {

	/*
	 * Key for period codes: -1 break -2 assembly -3 class meeting -4 advisory
	 * -5 clubs -7 lunch
	 */
	private final int BREAK = -1;
	private final int ASSEMBLY = -2;
	private final int CLASSMTG = -3;
	private final int ADVISORY = -4;
	private final int CLUBS = -5;
	private final int LUNCH = -7;

	private Day specialDay;
	private CurrentDate today;

	public SpecialSchedule() {

	}

	public Day getSpecialDay() {
		return specialDay;
	}

	public void setSpecialDay(Day specialDay) {
		this.specialDay = specialDay;
	}

	public void makeSpecialDay(int dayType, CurrentDate today) {
		this.today = today;
		switch (dayType) {
			case 0:
				makeSpecial();
				break;
			case 1:
				makeSpecialWenesday();
				break;
			case 2:
				makeSeniorPetDay();
				break;
			case 3:
				makeMarchFifth();
				break;
			case 4:
				makeDelayDay();
				break;
			case 5:
				makeSpringFling();
				break;
			case 6:
				makeFirstDay();
				break;
			case 7:
				makeGrandparentsDay();
				break;
			case 8:
				make1172014();
				break;
			case 9:
				make02112014();
				break;
			case 10:
				make03052014();
				break;
			case 11:
				make03062014();
				break;
			case 12:
				make03042014();
				break;
			case 13:
				make05022014();
				break;
			case 14:
				make08192014();
				break;
			case 15:
				make01162015();
			default:
				break;
		}
	}

	private void make08192014() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(805, today, 1));
		p.setNumber(CLASSMTG);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(805, today, 1));
		p.setEndTime(adjustTime(840, today, 1));
		p.setNumber(ASSEMBLY);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(850, today, 1));
		p.setEndTime(adjustTime(930, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(935, today, 1));
		p.setEndTime(adjustTime(1015, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1020, today, 1));
		p.setEndTime(adjustTime(1100, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1105, today, 1));
		p.setEndTime(adjustTime(1145, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1150, today, 1));
		p.setEndTime(adjustTime(1205, today, 1));
		p.setNumber(ADVISORY);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1210, today, 1));
		p.setEndTime(adjustTime(1245, today, 1));
		p.setNumber(LUNCH);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1250, today, 1));
		p.setEndTime(adjustTime(1330, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1335, today, 1));
		p.setEndTime(adjustTime(1415, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1420, today, 1));
		p.setEndTime(adjustTime(1505, today, 1));
		p.setNumber(7);
		temp.add(p);
		specialDay = temp;
	}

	private void make05022014() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(825, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(830, today, 1));
		p.setEndTime(adjustTime(855, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(925, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(930, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1000, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1055, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1100, today, 1));
		p.setEndTime(adjustTime(1125, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1130, today, 1));
		p.setEndTime(adjustTime(1230, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1235, today, 1));
		p.setEndTime(adjustTime(1310, today, 1));
		p.setNumber(-7);
		temp.add(p);
		specialDay = temp;
	}

	private void makeFirstDay() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(805, today, 1));
		p.setNumber(-3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(805, today, 1));
		p.setEndTime(adjustTime(840, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(850, today, 1));
		p.setEndTime(adjustTime(930, today, 1));
		p.setNumber(1);
		temp.add(p);
		p.setStartTime(adjustTime(935, today, 1));
		p.setEndTime(adjustTime(1015, today, 1));
		p.setNumber(2);
		temp.add(p);
		p.setStartTime(adjustTime(1020, today, 1));
		p.setEndTime(adjustTime(1100, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1105, today, 1));
		p.setEndTime(adjustTime(1145, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1150, today, 1));
		p.setEndTime(adjustTime(1205, today, 1));
		p.setNumber(-4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1210, today, 1));
		p.setEndTime(adjustTime(1245, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1250, today, 1));
		p.setEndTime(adjustTime(1330, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1335, today, 1));
		p.setEndTime(adjustTime(1415, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1420, today, 1));
		p.setEndTime(adjustTime(1505, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void makeSpecial() {
		Day temp = new Day();
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(845, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(850, today, 1));
		p.setEndTime(adjustTime(935, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(940, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1120, today, 1));
		p.setEndTime(adjustTime(1150, today, 1));
		p.setNumber(-13);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1155, today, 1));
		p.setEndTime(adjustTime(1235, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1240, today, 1));
		p.setEndTime(adjustTime(1325, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1330, today, 1));
		p.setEndTime(adjustTime(1415, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1420, today, 1));
		p.setEndTime(adjustTime(1505, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void make1172014() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(845, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(850, today, 1));
		p.setEndTime(adjustTime(935, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(940, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1120, today, 1));
		p.setEndTime(adjustTime(1205, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1205, today, 1));
		p.setEndTime(adjustTime(1250, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1255, today, 1));
		p.setEndTime(adjustTime(1340, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1345, today, 1));
		p.setEndTime(adjustTime(1430, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1435, today, 1));
		p.setEndTime(adjustTime(1520, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void makeSpringFling() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(825, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(830, today, 1));
		p.setEndTime(adjustTime(855, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(925, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(930, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1000, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1055, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1100, today, 1));
		p.setEndTime(adjustTime(1125, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1130, today, 1));
		p.setEndTime(adjustTime(1230, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1235, today, 1));
		p.setEndTime(adjustTime(1310, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		specialDay = temp;
	}

	private void makeSpecialWenesday() {
		Day temp = new Day();
		Period p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(940, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(945, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1110, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1115, today, 1));
		p.setEndTime(adjustTime(1130, today, 1));
		p.setNumber(-13);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1135, today, 1));
		p.setEndTime(adjustTime(1215, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1220, today, 1));
		p.setEndTime(adjustTime(1255, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1300, today, 1));
		p.setEndTime(adjustTime(1340, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1345, today, 1));
		p.setEndTime(adjustTime(1425, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1430, today, 1));
		p.setEndTime(adjustTime(1510, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void makeSeniorPetDay() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(835, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(840, today, 1));
		p.setEndTime(adjustTime(915, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(920, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1000, today, 1));
		p.setEndTime(adjustTime(1035, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1040, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1120, today, 1));
		p.setEndTime(adjustTime(1155, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1200, today, 1));
		p.setEndTime(adjustTime(1235, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void makeMarchFifth() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(900, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(905, today, 1));
		p.setEndTime(adjustTime(1005, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1010, today, 1));
		p.setEndTime(adjustTime(1110, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1115, today, 1));
		p.setEndTime(adjustTime(1215, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1215, today, 1));
		p.setEndTime(adjustTime(1305, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1305, today, 1));
		p.setEndTime(adjustTime(1405, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1410, today, 1));
		p.setEndTime(adjustTime(1510, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		specialDay = temp;

	}

	private void makeDelayDay() {
		Day temp = new Day();
		temp.setDayType('A');
		Period p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1000, today, 1));
		p.setEndTime(adjustTime(1055, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1055, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1115, today, 1));
		p.setEndTime(adjustTime(1230, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1230, today, 1));
		p.setEndTime(adjustTime(1325, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1325, today, 1));
		p.setEndTime(adjustTime(1420, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1425, today, 1));
		p.setEndTime(adjustTime(1520, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		specialDay = temp;
	}

	private void makeGrandparentsDay() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(830, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(835, today, 1));
		p.setEndTime(adjustTime(905, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(910, today, 1));
		p.setEndTime(adjustTime(940, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(945, today, 1));
		p.setEndTime(adjustTime(1015, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1020, today, 1));
		p.setEndTime(adjustTime(1050, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1055, today, 1));
		p.setEndTime(adjustTime(1125, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1130, today, 1));
		p.setEndTime(adjustTime(1200, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		specialDay = temp;
	}

	private void make02112014() {
		Day temp = new Day();
		temp.setDayType('E');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(900, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(905, today, 1));
		p.setEndTime(adjustTime(1005, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1015, today, 1));
		p.setEndTime(adjustTime(1045, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1050, today, 1));
		p.setEndTime(adjustTime(1205, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1210, today, 1));
		p.setEndTime(adjustTime(1300, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1305, today, 1));
		p.setEndTime(adjustTime(1405, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1410, today, 1));
		p.setEndTime(adjustTime(1510, today, 1));
		p.setNumber(4);
		temp.add(p);
		specialDay = temp;
	}

	private void make03052014() {

		Day temp = new Day();
		temp.setDayType('F');
		Period p = new Period();
		p.setStartTime(adjustTime(900, today, 1));
		p.setEndTime(adjustTime(955, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1000, today, 1));
		p.setEndTime(adjustTime(1055, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1100, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(-3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1120, today, 1));
		p.setEndTime(adjustTime(1230, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1235, today, 1));
		p.setEndTime(adjustTime(1320, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1325, today, 1));
		p.setEndTime(adjustTime(1420, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1425, today, 1));
		p.setEndTime(adjustTime(1520, today, 1));
		p.setNumber(5);
		temp.add(p);
		specialDay = temp;

	}

	private void make03062014() {
		Day temp = new Day();
		temp.setDayType('E');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(900, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(905, today, 1));
		p.setEndTime(adjustTime(1005, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1010, today, 1));
		p.setEndTime(adjustTime(1110, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1115, today, 1));
		p.setEndTime(adjustTime(1215, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1220, today, 1));
		p.setEndTime(adjustTime(1300, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1305, today, 1));
		p.setEndTime(adjustTime(1405, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1410, today, 1));
		p.setEndTime(adjustTime(1510, today, 1));
		p.setNumber(4);
		temp.add(p);
		specialDay = temp;
	}

	private void make03042014() {
		Day temp = new Day();
		temp.setDayType('D');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(900, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(905, today, 1));
		p.setEndTime(adjustTime(1005, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1010, today, 1));
		p.setEndTime(adjustTime(1120, today, 1));
		p.setNumber(7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1125, today, 1));
		p.setEndTime(adjustTime(1210, today, 1));
		p.setNumber(-2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1215, today, 1));
		p.setEndTime(adjustTime(1300, today, 1));
		p.setNumber(-7);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1305, today, 1));
		p.setEndTime(adjustTime(1405, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1410, today, 1));
		p.setEndTime(adjustTime(1510, today, 1));
		p.setNumber(3);
		temp.add(p);
		specialDay = temp;
	}

	private void make01162015() {
		Day temp = new Day();
		temp.setDayType('S');
		Period p = new Period();
		p.setStartTime(adjustTime(800, today, 1));
		p.setEndTime(adjustTime(845, today, 1));
		p.setNumber(1);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(850, today, 1));
		p.setEndTime(adjustTime(935, today, 1));
		p.setNumber(2);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(940, today, 1));
		p.setEndTime(adjustTime(1025, today, 1));
		p.setNumber(3);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1030, today, 1));
		p.setEndTime(adjustTime(1115, today, 1));
		p.setNumber(4);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1120, today, 1));
		p.setEndTime(adjustTime(1205, today, 1));
		p.setNumber(ASSEMBLY);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1205, today, 1));
		p.setEndTime(adjustTime(1250, today, 1));
		p.setNumber(LUNCH);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1255, today, 1));
		p.setEndTime(adjustTime(1340, today, 1));
		p.setNumber(5);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1345, today, 1));
		p.setEndTime(adjustTime(1430, today, 1));
		p.setNumber(6);
		temp.add(p);
		p = new Period();
		p.setStartTime(adjustTime(1435, today, 1));
		p.setEndTime(adjustTime(1520, today, 1));
		p.setNumber(7);
		temp.add(p);
		specialDay = temp;
	}

	public int adjustTime(int time, CurrentDate today, int direction) {
		int currentTime = time;
		// make 700 for DST
		currentTime += 700 * direction;
		return currentTime;

	}
}
