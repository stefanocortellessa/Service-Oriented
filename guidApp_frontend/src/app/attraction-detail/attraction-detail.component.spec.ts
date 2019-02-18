import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttractionDetailComponent } from './attraction-detail.component';

describe('AttractionDetailComponent', () => {
  let component: AttractionDetailComponent;
  let fixture: ComponentFixture<AttractionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttractionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttractionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
