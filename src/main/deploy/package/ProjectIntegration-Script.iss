;This file will be executed next to the application bundle image
;I.e. current directory will contain folder DeviceConfig with application files
[Setup]
AppId={{application}}
AppName=ProjectIntegration
AppVersion=1.0
AppVerName=ProjectIntegration 1.0
AppPublisher=Eletra Energy Solutions
AppComments=ProjectIntegration
AppCopyright=Copyright (C) 2017
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\ProjectIntegration
DisableStartupPrompt=Yes
DisableDirPage=Yes
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=Eletra Energy Solutions
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=ProjectIntegration-1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=ProjectIntegration\ProjectIntegration.ico
UninstallDisplayIcon={app}\ProjectIntegration.ico
UninstallDisplayName=ProjectIntegration
WizardImageStretch=No
WizardSmallImageFile=ProjectIntegration-setup-icon.bmp
ArchitecturesInstallIn64BitMode=
UsePreviousGroup=no
UsePreviousAppDir=no

[Languages]
Name: "en"; MessagesFile: "compiler:Default.isl"
Name: "pt"; MessagesFile: "compiler:Languages/BrazilianPortuguese.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "ProjectIntegration\ProjectIntegration.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "ProjectIntegration\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\ProjectIntegration"; Filename: "{app}\ProjectIntegration.exe"; IconFilename: "{app}\ProjectIntegration.ico"; Check: returnTrue()
Name: "{commondesktop}\ProjectIntegration"; Filename: "{app}\ProjectIntegration.exe";  IconFilename: "{app}\ProjectIntegration.ico"; Check: returnTrue()


[Run]                                                                                         
Filename: "{localappdata}\ProjectIntegration\uninstall.exe"; Flags: skipifdoesntexist           
Filename: "{app}\ProjectIntegration.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\ProjectIntegration.exe"; Description: "{cm:LaunchProgram,ProjectIntegration}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\ProjectIntegration.exe"; Parameters: "-install -svcName ""ProjectIntegration"" -svcDesc ""ProjectIntegration"" -mainExe ""ProjectIntegration.exe""  "; Check: returnFalse()
                  
[InstallDelete]  
Type: files; Name: "{commondesktop}\ZeusConfig.lnk"; 

[UninstallRun]
Filename: "{app}\ProjectIntegration.exe "; Parameters: "-uninstall -svcName ProjectIntegration -stopOnUninstall"; Check: returnFalse()  

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
