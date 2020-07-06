package br.com.studies.enums;

import java.io.File;

public enum OperationSystems {
  LINUX_OS_X("drivers/linux/"),
  MAC_OS_X("drivers/mac/"),
  WINDOWS_OS_X("drivers/windows/");

  private final String driverPath;

  OperationSystems(String driverPath) {
    this.driverPath = driverPath;
  }

  public String getDriversPath() {
    return new File(driverPath).getAbsolutePath();
  }
}
