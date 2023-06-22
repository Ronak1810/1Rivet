package com.maven.Spring;

public class Subject1 {
		private String maths, science, english;

		public String getMaths() {
			return maths;
		}

		public void setMaths(String maths) {
			this.maths = maths;
		}

		public String getScience() {
			return science;
		}

		public void setScience(String science) {
			this.science = science;
		}

		public String getEnglish() {
			return english;
		}

		public void setEnglish(String english) {
			this.english = english;
		}

		public Subject(String maths, String science, String english) {
			super();
			this.maths = maths;
			this.science = science;
			this.english = english;
		}

		public Subject() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Subject [maths=" + maths + ", science=" + science + ", english=" + english + "]";
		}
}
