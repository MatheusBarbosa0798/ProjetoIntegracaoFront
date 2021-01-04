;This file will be executed next to the application bundle image
;I.e. current directory will contain folder DeviceConfig with application files
[Setup]
AppId={{application}}
AppName=ProjectSetup
AppVersion=1.0
AppVerName=Project Integration 1.0
AppPublisher=Eletra Energy Solutions
AppComments=ProjectIntegration
AppCopyright=Copyright (C) 2020
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
OutputBaseFilename=Project Integration 1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=ProjectIntegration\DeviceConfig.ico
UninstallDisplayIcon={app}\DeviceConfig.ico
UninstallDisplayName=ProjectIntegration
WizardImageStretch=No
WizardSmallImageFile=DeviceConfig-setup-icon.bmp
ArchitecturesInstallIn64BitMode=
UsePreviousGroup=no
UsePreviousAppDir=no

[Languages]
Name: "en"; MessagesFile: "compiler:Default.isl"
Name: "pt"; MessagesFile: "compiler:Languages/BrazilianPortuguese.isl"

[Files]
Source: "ProjectIntegration\ProjectSetup.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "ProjectIntegration\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\ProjectIntegration"; Filename: "{app}\ProjectSetup.exe"; IconFilename: "{app}\DeviceConfig.ico"; Check: returnTrue()
Name: "{commondesktop}\ProjectIntegration"; Filename: "{app}\ProjectSetup.exe";  IconFilename: "{app}\DeviceConfig.ico"; Check: returnTrue()


[Run]                                                                                         
Filename: "{localappdata}\ProjectIntegration\unins000.exe"; Flags: skipifdoesntexist           
Filename: "{app}\ProjectSetup.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\ProjectSetup.exe"; Description: "{cm:LaunchProgram,DeviceConfig}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\ProjectSetup.exe"; Parameters: "-install -svcName ""ProjectIntegration"" -svcDesc ""ProjectIntegration"" -mainExe ""ProjectSetup.exe""  "; Check: returnFalse()
                  
[InstallDelete]  
Type: files; Name: "{commondesktop}\ZeusConfig.lnk"; 

[UninstallRun]
Filename: "{app}\Uninstall.exe "; Parameters: "-uninstall -svcName ProjectIntegration -stopOnUninstall"; Check: returnFalse()  

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
