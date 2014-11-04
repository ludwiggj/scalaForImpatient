package com.bt.refactoring;

// Step11: New enum to represent movie category
public enum MovieCategory {
	REGULAR {
		@Override
		public double getCharge(int daysRented) {
			double amount = 2;
			if (daysRented > 2) {
				amount += (daysRented - 2) * 1.5;
			}
			return amount;
		}
	},
	NEW_RELEASE {
		@Override
		public double getCharge(int daysRented) {
			return daysRented * 3;
		}

		@Override
		public int getFrequentRenterPoints(int daysRented) {
			if (daysRented > 1) {
				return 2;
			} else {
				return 1;
			}
		}
	},
	CHILDRENS {
		@Override
		public double getCharge(int daysRented) {
			double amount = 1.5;
			if (daysRented > 3) {
				amount += (daysRented - 3) * 1.5;
			}
			return amount;
		}
	};

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}