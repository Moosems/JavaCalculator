/*
 * HistoryManager
 * 
 * Version 1.0
 *
 * 04/17/2024
 * 
 * Copyright notice - Moosems
 */

package Calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

class HistoryManager {
	public static String getUserDataDir() {
        String osName = System.getProperty("os.name").toLowerCase();
        String userDataDir = "";

        if (osName.contains("win")) {
            userDataDir = System.getenv("APPDATA");
        } else if (osName.contains("mac")) {
            userDataDir = System.getProperty("user.home") + "/Library/Application Support";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            userDataDir = System.getProperty("user.home") + "/.local/share";
        } else if (osName.contains("sunos")) {
            userDataDir = System.getProperty("user.home");
        }

        return String.format("%s/JavaCalculator/", userDataDir);
	}
	public static void createHistoryFile() {
		File historyDir = new File(
			HistoryManager.getUserDataDir()
		);
		File historyFile = new File(
			HistoryManager.getUserDataDir() + "history.txt"
		);
		try {
			historyDir.mkdirs();
			historyFile.createNewFile();
		} catch (IOException e) {
			throw new Error("Could not create history file!");
		}
	}
	
	public static void listHistory() {
		System.out.println("[Computation History]");
		BufferedReader historyFile;
		try {
			historyFile = new BufferedReader(
				new FileReader(
					HistoryManager.getUserDataDir() + "history.txt"
				)
			);
		} catch (IOException e) {
			throw new Error("Could not read file!");
		}

		String line = "";
		while (line != null) {
			try {
				line = historyFile.readLine();
			} catch (IOException e) {
				throw new Error("Failed to read data!");
			}
			if (line == null) {
				System.out.println("[History Complete]");
				continue;
			}
			CustomTuple data = CustomTuple.from_string(line);
			data.print_data();
		}
	}

	public static void clearHistory() {
		FileWriter historyFile;
		try {
			historyFile = new FileWriter(
				HistoryManager.getUserDataDir() + "history.txt"
		);
		} catch(IOException e) {
			throw new Error("Could not read/erase file data!");
		}
	}

	public static void appendLine(CustomTuple data) {
		FileWriter historyFile;
		try {
			historyFile = new FileWriter(
				HistoryManager.getUserDataDir() + "history.txt",
				true)
			;
		} catch(IOException e) {
			throw new Error("Could not read/erase file data!");
		}
		String dataStringified = data.to_string();
		try {
			historyFile.write(dataStringified);
			historyFile.close();
		} catch (IOException e) {
			throw new Error("Could not write file data!");
		}
	}
}